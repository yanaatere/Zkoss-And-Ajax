package service;

import java.util.List;

import entity.TrDetailPenjualan;
import entity.TrHeaderPenjualan;

public interface TrDetailPenjualanSvc {
	public void save(TrDetailPenjualan trDetailPenjualanDao);
	public void update(TrDetailPenjualan trDetailPenjualanDao);
	public void delete (String kodeDetail);
	public List<TrDetailPenjualan> findAll();
	public TrDetailPenjualan findOne(String kodeDetail);
	public List<TrDetailPenjualan> findByHeader(String noNota);
}
