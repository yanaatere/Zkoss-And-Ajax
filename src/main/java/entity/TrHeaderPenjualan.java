package entity;

import java.sql.Date;

public class TrHeaderPenjualan {
	private String noNota;
	private Date tanggalTransaksi;
	private int hargaTotal;
	private int globalDiskon;
	private MstCustomer kodeCustomer;
	private MstKaryawan kodeKaryawan;
	
	public String getNoNota() {
		return noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	
	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}
	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}
	public int getHargaTotal() {
		return hargaTotal;
	}
	public void setHargaTotal(int hargaTotal) {
		this.hargaTotal = hargaTotal;
	}
	public int getGlobalDiskon() {
		return globalDiskon;
	}
	public void setGlobalDiskon(int globalDiskon) {
		this.globalDiskon = globalDiskon;
	}
	public MstCustomer getKodeCustomer() {
		return kodeCustomer;
	}
	public void setKodeCustomer(MstCustomer kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}
	public MstKaryawan getKodeKaryawan() {
		return kodeKaryawan;
	}
	public void setKodeKaryawan(MstKaryawan kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}
	
	
	
}
