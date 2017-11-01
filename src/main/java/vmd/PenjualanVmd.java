package vmd;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.Button;
import org.zkoss.zul.Messagebox.ClickEvent;

import entity.TrHeaderPenjualan;
import service.TrHeaderPenjualanSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PenjualanVmd {

	@WireVariable
	private TrHeaderPenjualanSvc trHeaderPenjualanSvc;
	private TrHeaderPenjualan trHeaderPenjualan;
	private List<TrHeaderPenjualan> listHeader = new ArrayList<>();
	private String search;

	public TrHeaderPenjualanSvc getTrHeaderPenjualanSvc() {
		return trHeaderPenjualanSvc;
	}

	public void setTrHeaderPenjualanSvc(
			TrHeaderPenjualanSvc trHeaderPenjualanSvc) {
		this.trHeaderPenjualanSvc = trHeaderPenjualanSvc;
	}

	public TrHeaderPenjualan getTrHeaderPenjualan() {
		return trHeaderPenjualan;
	}

	public void setTrHeaderPenjualan(TrHeaderPenjualan trHeaderPenjualan) {
		this.trHeaderPenjualan = trHeaderPenjualan;
	}

	public List<TrHeaderPenjualan> getListHeader() {
		return listHeader;
	}

	public void setListHeader(List<TrHeaderPenjualan> listHeader) {
		this.listHeader = listHeader;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Init
	public void load() {
		listHeader = trHeaderPenjualanSvc.findAll();
	}

	@Command("add")
	public void add() {
		TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();
		Sessions.getCurrent().setAttribute("header", trHeaderPenjualan);
		Executions.sendRedirect("/transaksi/penjualanedit.zul");
	}

	@Command("edit")
	@NotifyChange({ "includeSrc", "p" })
	public void edit() {
		if (trHeaderPenjualan == null) {
			Messagebox.show("Pilih Data Yang Akan Di Edit");
		} else {
			Sessions.getCurrent().setAttribute("header", trHeaderPenjualan);
			Executions.sendRedirect("/transaksi/penjualanedit.zul");
		}
	}

	@Command("delete")
	public void delete() {
		if (trHeaderPenjualan != null) {
			Messagebox.show("Apakah Anda Yakin Mau Di Hapus?", "Perhatian",
					new Button[] { Button.YES, Button.NO },
					Messagebox.QUESTION, Button.NO,
					new EventListener<Messagebox.ClickEvent>() {

						@Override
						public void onEvent(ClickEvent event) throws Exception {
							if (Messagebox.ON_YES.equals(event.getName())) {
								trHeaderPenjualanSvc.delete(trHeaderPenjualan
										.getNoNota());
								trHeaderPenjualanSvc
										.deletedetail(trHeaderPenjualan
												.getNoNota());
								listHeader.remove(trHeaderPenjualan);
								BindUtils.postNotifyChange(null, null,
										PenjualanVmd.this, "listHeader");
								Clients.showNotification(
										"Data Berhasil di delete",
										Clients.NOTIFICATION_TYPE_INFO, null,
										null, 500);
							}
						}
					});
		} else {
			Messagebox.show("Pilih Data Yang Akan Delete");
		}
	}

	@Command("search")
	@NotifyChange("listHeader")
	public void search() {
		listHeader.clear();
		listHeader = trHeaderPenjualanSvc.Search(search);
	}
}
