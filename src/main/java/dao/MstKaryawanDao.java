package dao;

import java.util.List;

import entity.MstKaryawan;

public interface MstKaryawanDao {
	public void save(MstKaryawan mstKaryawan);
	public void update(MstKaryawan mstKaryawan);
	public void delete(String kodeKaryawan);
	public List<MstKaryawan> findAll();
	public MstKaryawan findone(String kodeKaryawan);
	public MstKaryawan findUsernameAndPassword(String username, String password);
}
