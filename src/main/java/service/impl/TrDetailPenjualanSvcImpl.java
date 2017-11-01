package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TrDetailPenjualanDao;
import entity.TrDetailPenjualan;
import service.TrDetailPenjualanSvc;

@Service("trDetailPenjualanSvc")
public class TrDetailPenjualanSvcImpl implements TrDetailPenjualanSvc{

	@Autowired
	TrDetailPenjualanDao trDetailPenjualanDao;
	
	@Override
	public void save(TrDetailPenjualan trDetailPenjualanDao) {
		this.trDetailPenjualanDao.save(trDetailPenjualanDao);
		
	}

	@Override
	public void update(TrDetailPenjualan trDetailPenjualanDao) {
		this.trDetailPenjualanDao.update(trDetailPenjualanDao);
		
	}

	@Override
	public void delete(String kodeDetail) {
		this.trDetailPenjualanDao.delete(kodeDetail);
		
	}

	@Override
	public List<TrDetailPenjualan> findAll() {
		return this.trDetailPenjualanDao.findAll();
	}

	@Override
	public TrDetailPenjualan findOne(String kodeDetail) {
		return this.trDetailPenjualanDao.findOne(kodeDetail);
	}

	@Override
	public List<TrDetailPenjualan> findByHeader(String noNota) {
		return this.trDetailPenjualanDao.findByHeader(noNota);
	}

}
