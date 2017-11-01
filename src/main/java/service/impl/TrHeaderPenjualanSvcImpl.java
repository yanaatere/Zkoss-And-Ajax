package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstBarangDao;
import dao.TrDetailPenjualanDao;
import dao.TrHeaderPenjualanDao;
import entity.MstBarang;
import entity.TrDetailPenjualan;
import entity.TrHeaderPenjualan;
import service.TrHeaderPenjualanSvc;

@Service("trHeaderPenjualanSvc")
public class TrHeaderPenjualanSvcImpl implements TrHeaderPenjualanSvc {

	@Autowired
	private TrHeaderPenjualanDao trHeaderPenjualanDao;
	
	@Autowired
	private TrDetailPenjualanDao trDetailPenjualanDao;
	
	@Autowired
	private MstBarangDao mstBarangDao;

	@Override
	public void save(TrHeaderPenjualan trHeaderPenjualan) {
		trHeaderPenjualanDao.save(trHeaderPenjualan);

	}

	@Override
	public void update(TrHeaderPenjualan trHeaderPenjualan) {
		trHeaderPenjualanDao.update(trHeaderPenjualan);

	}

	@Override
	public void delete(String trHeaderPenjualan) {
		trHeaderPenjualanDao.delete(trHeaderPenjualan);

	}

	@Override
	public List<TrHeaderPenjualan> findAll() {
		return trHeaderPenjualanDao.findAll();
	}

	@Override
	public TrHeaderPenjualan findOne(String noNota) {
		return trHeaderPenjualanDao.findOne(noNota);
	}

	@Override
	public void deletedetail(String trDetailPenjualan) {
		List<TrDetailPenjualan> list = trDetailPenjualanDao.findByHeader(trDetailPenjualan);
		
		int stokAkhir;
		int jumlahDetail=0;
		MstBarang mstBarang = new MstBarang();
		
		for (TrDetailPenjualan penjualn : list) {
			mstBarang = mstBarangDao.findOne(penjualn.getKodeBarang().getKodeBarang());
			jumlahDetail = jumlahDetail + penjualn.getQty();
		}
		
		stokAkhir = mstBarang.getStokBarang() + jumlahDetail;
		mstBarang.setStokBarang(stokAkhir);
		mstBarangDao.updateStok(mstBarang);		
		this.trHeaderPenjualanDao.deletedetail(trDetailPenjualan);
	}

	@Override
	public List<TrHeaderPenjualan> Search(String search) {
		
		
		return this.trHeaderPenjualanDao.Search(search);
	}
}
