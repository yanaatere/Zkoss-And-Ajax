package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstBarangDao;
import entity.MstBarang;
import service.MstBarangSvc;

@Service("mstBarangSvc")
public class MstBarangSvcImpl implements MstBarangSvc {

	@Autowired
	private MstBarangDao mstBarangDao;
	
	@Override
	public List<MstBarang> findAllData() {
		// TODO Auto-generated method stub
		return mstBarangDao.findAll();
	}

	@Override
	public void save(MstBarang mstBarang) {
		// TODO Auto-generated method stub
		mstBarangDao.save(mstBarang);
	}

	@Override
	public void update(MstBarang mstBarang) {
		// TODO Auto-generated method stub
		mstBarangDao.update(mstBarang);
	}

	@Override
	public void delete(String kodeBarang) {
		// TODO Auto-generated method stub
		mstBarangDao.delete(kodeBarang);
	}

	@Override
	public MstBarang findOne(String kodeBarang) {
		// TODO Auto-generated method stub
		return mstBarangDao.findOne(kodeBarang);
	}

	@Override
	public void updateStok(MstBarang mstBarang) {
		mstBarangDao.updateStok(mstBarang);
		
	}
	
}
