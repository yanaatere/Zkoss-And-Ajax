package dao;

import java.util.List;

import entity.MstBarang;

public interface MstBarangDao {
	public void save(MstBarang mstBarang);
	public void update(MstBarang mstBarang);
	public void delete (String mstBarang);
	public List<MstBarang> findAll();
	public MstBarang findOne(String kodeBarang);
	public void updateStok(MstBarang mstBarang);
}
