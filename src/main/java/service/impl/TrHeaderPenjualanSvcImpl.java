package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TrHeaderPenjualanDao;
import entity.TrHeaderPenjualan;
import service.TrHeaderPenjualanSvc;

@Service("trHeaderPenjualanSvc")
public class TrHeaderPenjualanSvcImpl implements TrHeaderPenjualanSvc {

	@Autowired
	TrHeaderPenjualanDao trHeaderPenjualanDao;

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
		this.trHeaderPenjualanDao.deletedetail(trDetailPenjualan);
	}

	@Override
	public List<TrHeaderPenjualan> Search(String search) {

		return this.trHeaderPenjualanDao.Search(search);
	}
}
