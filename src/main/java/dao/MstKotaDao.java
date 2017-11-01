package dao;

import java.util.List;

import entity.MstKota;

public interface MstKotaDao {
	public void save(MstKota mstKota);
	public void update(MstKota mstKota);
	public void delete(String kodeKota);
	public List<MstKota> findAll();
	public MstKota findone(String kodeKota);
}
