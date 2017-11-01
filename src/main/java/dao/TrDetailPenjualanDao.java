package dao;

import java.util.List;

import entity.TrDetailPenjualan;

public interface TrDetailPenjualanDao {
	public void save(TrDetailPenjualan trDetailPenjualanDao);
	public void update(TrDetailPenjualan trDetailPenjualanDao);
	public void delete (String kodeDetail);
	public List<TrDetailPenjualan> findAll();
	public TrDetailPenjualan findOne(String kodeDetail);
	public List<TrDetailPenjualan> findByHeader(String noNota);
}
