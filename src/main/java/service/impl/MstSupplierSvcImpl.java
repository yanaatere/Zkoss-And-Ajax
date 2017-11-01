package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstSupplierDao;
import entity.MstSupplier;
import service.MstSupplierSvc;

@Service("mstSupplierSvc")
public class MstSupplierSvcImpl implements MstSupplierSvc {

	@Autowired
	private MstSupplierDao mstSupplierDao;
	
	@Override
	public List<MstSupplier> findAllData() {
		// TODO Auto-generated method stub
		return mstSupplierDao.findAll();
	}

	@Override
	public void save(MstSupplier mstSupplier) {
		// TODO Auto-generated method stub
		mstSupplierDao.save(mstSupplier);
	}

	@Override
	public void update(MstSupplier mstSupplier) {
		// TODO Auto-generated method stub
		mstSupplierDao.update(mstSupplier);
	}

	@Override
	public void delete(String kodeSupplier) {
		// TODO Auto-generated method stub
		mstSupplierDao.delete(kodeSupplier);
	}

	@Override
	public MstSupplier findOne(String kodeSupplier) {
		// TODO Auto-generated method stub
		return mstSupplierDao.findOne(kodeSupplier);
	}

}
