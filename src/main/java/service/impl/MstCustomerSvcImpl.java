package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstCustomerDao;
import entity.MstCustomer;
import service.MstCustomerSvc;

@Service("mstCustomerSvc")
public class MstCustomerSvcImpl implements MstCustomerSvc {

	@Autowired
	private MstCustomerDao mstCustomerDao;
	
	@Override
	public List<MstCustomer> findAll() {
		// TODO Auto-generated method stub
		return mstCustomerDao.findAll();
	}

	@Override
	public void save(MstCustomer mstCustomer) {
		// TODO Auto-generated method stub
		mstCustomerDao.save(mstCustomer);
	}

	@Override
	public void update(MstCustomer mstCustomer) {
		// TODO Auto-generated method stub
		mstCustomerDao.update(mstCustomer);
	}

	@Override
	public void delete(String kodeCustomer) {
		// TODO Auto-generated method stub
		mstCustomerDao.delete(kodeCustomer);
	}

	@Override
	public MstCustomer findOne(String kodeCustomer) {
		// TODO Auto-generated method stub
		return mstCustomerDao.findOne(kodeCustomer);
	}
	
}
