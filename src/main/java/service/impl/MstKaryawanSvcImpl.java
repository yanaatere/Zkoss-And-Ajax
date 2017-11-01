package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstKaryawanDao;
import entity.MstKaryawan;
import service.MstKaryawanSvc;

@Service("mstKaryawanSvc")
public class MstKaryawanSvcImpl implements MstKaryawanSvc {

	@Autowired
	private MstKaryawanDao mstKaryawanDao;
	
	@Override
	public List<MstKaryawan> findAll() {
		return mstKaryawanDao.findAll();
	}
	
	@Override
	public void save(MstKaryawan mstKaryawan) {
		mstKaryawanDao.save(mstKaryawan);
		
	}

	@Override
	public void update(MstKaryawan mstKaryawan) {
		mstKaryawanDao.update(mstKaryawan);
		
	}

	@Override
	public void delete(String kodeKaryawan) {
		mstKaryawanDao.delete(kodeKaryawan);
		
	}

	@Override
	public MstKaryawan findone(String kodeKaryawan) {
		return mstKaryawanDao.findone(kodeKaryawan);
		 
	}

	@Override
	public MstKaryawan login(String username, String password) {
		return mstKaryawanDao.findUsernameAndPassword(username, password);
	}
}
