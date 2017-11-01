package service;

import java.util.List;

import entity.TrHeaderPenjualan;

public interface TrHeaderPenjualanSvc {
	public void save(TrHeaderPenjualan trHeaderPenjualan);
	public void update(TrHeaderPenjualan trHeaderPenjualan);
	public void delete (String trHeaderPenjualan);
	public void deletedetail(String trDetailPenjualan);
	public List<TrHeaderPenjualan> findAll();
	public TrHeaderPenjualan findOne(String noNota);
	public List<TrHeaderPenjualan> Search(String search);
}
