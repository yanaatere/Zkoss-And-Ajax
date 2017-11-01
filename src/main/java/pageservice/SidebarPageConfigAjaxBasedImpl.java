package pageservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SidebarPageConfigAjaxBasedImpl implements SidebarPageConfig{

	HashMap<String, SidebarPage> pageMap = new LinkedHashMap<String,SidebarPage>();
	public SidebarPageConfigAjaxBasedImpl() {
		pageMap.put("fn1", new SidebarPage("Login", "/imgs/fn.png", "/login.zul"));
		pageMap.put("fn2", new SidebarPage("Luas", "/imgs/fn.png", "/contoh.zul"));
		pageMap.put("fn3", new SidebarPage("Customer", "/imgs/fn.png", "/master/customer/customer.zul"));
		pageMap.put("fn4", new SidebarPage("Transaksi", "/imgs/fn.png", "/transaksi/penjualan.zul"));
	}
	
	
	public List<SidebarPage> getPages() {
		return new ArrayList<SidebarPage>(pageMap.values());
	}

}
