package entity;

public class TrDetailPenjualan {
	private String kodeDetail;
	private int qty;
	private int subtotal;
	private int diskon;
	private int hargaSatuan;
	private MstBarang kodeBarang;
	private TrHeaderPenjualan noNota;
	public String getKodeDetail() {
		return kodeDetail;
	}
	public void setKodeDetail(String kodeDetail) {
		this.kodeDetail = kodeDetail;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public int getDiskon() {
		return diskon;
	}
	public void setDiskon(int diskon) {
		this.diskon = diskon;
	}
	public int getHargaSatuan() {
		return hargaSatuan;
	}
	public void setHargaSatuan(int hargaSatuan) {
		this.hargaSatuan = hargaSatuan;
	}
	public MstBarang getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(MstBarang kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	public TrHeaderPenjualan getNoNota() {
		return noNota;
	}
	public void setNoNota(TrHeaderPenjualan noNota) {
		this.noNota = noNota;
	}
	
	
}
