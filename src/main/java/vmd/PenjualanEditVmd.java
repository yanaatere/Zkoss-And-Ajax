package vmd;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;
import entity.MstBarang;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.TrDetailPenjualan;
import entity.TrHeaderPenjualan;
import service.MstBarangSvc;
import service.MstCustomerSvc;
import service.MstKaryawanSvc;
import service.TrDetailPenjualanSvc;
import service.TrHeaderPenjualanSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PenjualanEditVmd {

	@WireVariable
	private TrHeaderPenjualanSvc trHeaderPenjualanSvc;

	@WireVariable
	private TrDetailPenjualanSvc trDetailPenjualanSvc;

	@WireVariable
	private MstBarangSvc mstBarangSvc;

	@WireVariable
	private MstCustomerSvc mstCustomerSvc;

	@WireVariable
	private MstKaryawanSvc mstKaryawanSvc;

	private TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();
	private TrDetailPenjualan trDetailPenjualan = new TrDetailPenjualan();
	private MstBarang barang = new MstBarang();
	private MstCustomer mstCustomer;
	private MstKaryawan mstKaryawan;
	private List<TrDetailPenjualan> listDetail = new ArrayList<>();
	private List<MstBarang> listBarang = new ArrayList<>();
	private List<MstCustomer> listCustomer = new ArrayList<>();
	private List<MstKaryawan> listKaryawan = new ArrayList<>();
	private boolean visible = true;
	private boolean statusPopUp = false;
	private boolean readonly = false;
	private int tampungSubTotal;
	private int tampung = 0;
	private int tampungHargaTotal;
	private int totalSebelumDiskon;
	private int stok = 0;

	public TrHeaderPenjualanSvc getTrHeaderPenjualanSvc() {
		return trHeaderPenjualanSvc;
	}

	public void setTrHeaderPenjualanSvc(
			TrHeaderPenjualanSvc trHeaderPenjualanSvc) {
		this.trHeaderPenjualanSvc = trHeaderPenjualanSvc;
	}

	public TrDetailPenjualanSvc getTrDetailPenjualanSvc() {
		return trDetailPenjualanSvc;
	}

	public void setTrDetailPenjualanSvc(
			TrDetailPenjualanSvc trDetailPenjualanSvc) {
		this.trDetailPenjualanSvc = trDetailPenjualanSvc;
	}

	public MstBarangSvc getMstBarangSvc() {
		return mstBarangSvc;
	}

	public void setMstBarangSvc(MstBarangSvc mstBarangSvc) {
		this.mstBarangSvc = mstBarangSvc;
	}

	public MstCustomerSvc getMstCustomerSvc() {
		return mstCustomerSvc;
	}

	public void setMstCustomerSvc(MstCustomerSvc mstCustomerSvc) {
		this.mstCustomerSvc = mstCustomerSvc;
	}

	public MstKaryawanSvc getMstKaryawanSvc() {
		return mstKaryawanSvc;
	}

	public void setMstKaryawanSvc(MstKaryawanSvc mstKaryawanSvc) {
		this.mstKaryawanSvc = mstKaryawanSvc;
	}

	public TrHeaderPenjualan getTrHeaderPenjualan() {
		return trHeaderPenjualan;
	}

	public void setTrHeaderPenjualan(TrHeaderPenjualan trHeaderPenjualan) {
		this.trHeaderPenjualan = trHeaderPenjualan;
	}

	public TrDetailPenjualan getTrDetailPenjualan() {
		return trDetailPenjualan;
	}

	public void setTrDetailPenjualan(TrDetailPenjualan trDetailPenjualan) {
		this.trDetailPenjualan = trDetailPenjualan;
	}

	public MstBarang getBarang() {
		return barang;
	}

	public void setBarang(MstBarang barang) {
		this.barang = barang;
	}

	public MstCustomer getMstCustomer() {
		return mstCustomer;
	}

	public void setMstCustomer(MstCustomer mstCustomer) {
		this.mstCustomer = mstCustomer;
	}

	public MstKaryawan getMstKaryawan() {
		return mstKaryawan;
	}

	public void setMstKaryawan(MstKaryawan mstKaryawan) {
		this.mstKaryawan = mstKaryawan;
	}

	public List<TrDetailPenjualan> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<TrDetailPenjualan> listDetail) {
		this.listDetail = listDetail;
	}

	public List<MstBarang> getListBarang() {
		return listBarang;
	}

	public void setListBarang(List<MstBarang> listBarang) {
		this.listBarang = listBarang;
	}

	public List<MstCustomer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<MstCustomer> listCustomer) {
		this.listCustomer = listCustomer;
	}

	public List<MstKaryawan> getListKaryawan() {
		return listKaryawan;
	}

	public void setListKaryawan(List<MstKaryawan> listKaryawan) {
		this.listKaryawan = listKaryawan;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isStatusPopUp() {
		return statusPopUp;
	}

	public void setStatusPopUp(boolean statusPopUp) {
		this.statusPopUp = statusPopUp;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public int getTampungSubTotal() {
		return tampungSubTotal;
	}

	public void setTampungSubTotal(int tampungSubTotal) {
		this.tampungSubTotal = tampungSubTotal;
	}

	public int getTampung() {
		return tampung;
	}

	public void setTampung(int tampung) {
		this.tampung = tampung;
	}

	public int getTampungHargaTotal() {
		return tampungHargaTotal;
	}

	public void setTampungHargaTotal(int tampungHargaTotal) {
		this.tampungHargaTotal = tampungHargaTotal;
	}

	public int getTotalSebelumDiskon() {
		return totalSebelumDiskon;
	}

	public void setTotalSebelumDiskon(int totalSebelumDiskon) {
		this.totalSebelumDiskon = totalSebelumDiskon;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	@Init
	public void load() {
		trHeaderPenjualan = (TrHeaderPenjualan) Sessions.getCurrent()
				.getAttribute("header");
		mstKaryawan = (MstKaryawan) Sessions.getCurrent().getAttribute("user");

		if (trHeaderPenjualan.getNoNota() != null) {
			String kodeCustomer = trHeaderPenjualan.getKodeCustomer()
					.getKodeCustomer();
			mstCustomer = mstCustomerSvc.findOne(kodeCustomer);
			listCustomer = mstCustomerSvc.findAll();
			if (trHeaderPenjualan.getNoNota() != null) {
				setVisible(false);
				setReadonly(true);
			}
			trHeaderPenjualan.setKodeKaryawan(mstKaryawan);
			listDetail = trDetailPenjualanSvc.findByHeader(trHeaderPenjualan.getNoNota());
			listBarang = mstBarangSvc.findAllData();
		} else {
			listCustomer = mstCustomerSvc.findAll();
			if (trHeaderPenjualan.getNoNota() != null) {
				setVisible(true);
				setReadonly(true);
			}
			trHeaderPenjualan.setKodeKaryawan(mstKaryawan);
			listDetail = trDetailPenjualanSvc.findByHeader(trHeaderPenjualan.getNoNota());
			listBarang = mstBarangSvc.findAllData();
		}
	}

	@Command("save")
	public void save() {
		TrHeaderPenjualan findHeader = trHeaderPenjualanSvc
				.findOne(trHeaderPenjualan.getNoNota());
		if (findHeader.getNoNota() == null) {
			trHeaderPenjualanSvc.save(trHeaderPenjualan);
			for (TrDetailPenjualan det : listDetail) {
				String kodeBarang = trDetailPenjualan.getKodeBarang()
						.getKodeBarang();
				MstBarang mstBarang = new MstBarang();
				mstBarang = mstBarangSvc.findOne(kodeBarang);
				int stokAkhir = mstBarang.getStokBarang() - det.getQty();
				if (stokAkhir < 0) {
					Messagebox.show("Pembelian Melibihi Stock");
				} else {
					mstBarang.setStokBarang(stokAkhir);
					mstBarang.setKodeBarang(kodeBarang);
					det.setNoNota(trHeaderPenjualan);
					trDetailPenjualanSvc.save(det);
					TrDetailPenjualan detail = trDetailPenjualanSvc.findOne(det
							.getKodeDetail());
					if (detail != null) {
						mstBarangSvc.updateStok(mstBarang);
					}
					Clients.showNotification("Data Berhasil Disimpan",
							Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
//					Include inc = (Include) Executions.getCurrent()
//							.getDesktop().getPage("index")
//							.getFellow("mainInclude");
//					inc.setSrc("/transaksi/penjualan.zul");
					Executions.sendRedirect("/transaksi/penjualan.zul");
				}
			}
		} else if (findHeader.getNoNota() != null) {
			trHeaderPenjualanSvc.update(trHeaderPenjualan);
			Clients.showNotification("Data Berhasil Di update",
					Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop()
					.getPage("index").getFellow("mainInclude");
			inc.setSrc("transaksi/penjualan.zul");
		}
	}
	@Command("back")
	public void back(){
		Executions.sendRedirect("/transaksi/penjualan.zul");
	}
	
	@Command("addDetail")
	@NotifyChange({"statusPopUp","trDetailPenjualan","stok"})
	public void addDetail(){
		setStatusPopUp(true);
		trDetailPenjualan = new TrDetailPenjualan();
		setStok(0);
	}
	
	@Command("saveDetail")
	@NotifyChange({"listDetail", "statusPopUp", "trHeaderPenjualan"})
	public void saveDetail(){
		listDetail.add(trDetailPenjualan);
		int hasil = 0;
		for (TrDetailPenjualan det : listDetail) {
			hasil = hasil + det.getSubtotal();
		}
		trHeaderPenjualan.setHargaTotal(hasil);
		setStatusPopUp(false);
	}
	
	@Command("backDetail")
	@NotifyChange("statusPopUp")
	public void backDetail(){
		setStatusPopUp(false);
	}
	
	@Command("removeDetail")
	@NotifyChange("listDetail")
	public void removeDetail(){
		listDetail.remove(trDetailPenjualan);
	}
	
	@Command("hitungSubTotal")
	@NotifyChange("trDetailPenjualan")
	public void hitungSubTotal(){
		if (trDetailPenjualan.getHargaSatuan() != 0 && trDetailPenjualan.getQty() != 0 && trDetailPenjualan.getDiskon()==0 ) {
			tampungSubTotal = trDetailPenjualan.getHargaSatuan() * trDetailPenjualan.getQty();
			trDetailPenjualan.setSubtotal(tampungSubTotal);
		} else if (trDetailPenjualan.getHargaSatuan() != 0 && trDetailPenjualan.getQty() != 0 && trDetailPenjualan.getDiskon()!=0) {
			tampungSubTotal = trDetailPenjualan.getHargaSatuan() * trDetailPenjualan.getQty() - 
					(trDetailPenjualan.getHargaSatuan() * trDetailPenjualan.getQty() * trDetailPenjualan.getDiskon()/100);
			trDetailPenjualan.setSubtotal(tampungSubTotal);
		}
	}
	
	@Command("hitungHargaTotal")
	@NotifyChange("trHeaderPenjualan")
	public void hitungHargaTotal(){
		if (trHeaderPenjualan.getGlobalDiskon()!=0) {
			tampungHargaTotal = trHeaderPenjualan.getHargaTotal()-(trHeaderPenjualan.getHargaTotal()* trHeaderPenjualan.getGlobalDiskon()/100);
			trHeaderPenjualan.setHargaTotal(tampungHargaTotal);
		}
	}
	
	@Command("tampilStock")
	@NotifyChange("stok")
	public void tampilStock(){
		if (trDetailPenjualan.getKodeBarang().getKodeBarang() != null) {
			MstBarang barang = new MstBarang();
			barang = mstBarangSvc.findOne(trDetailPenjualan.getKodeBarang().getKodeBarang());
			stok = barang.getStokBarang();
		}
	}
}