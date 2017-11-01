import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.TrDetailPenjualanSvc;
import dao.MstKaryawanDao;
import entity.MstKaryawan;
import entity.TrDetailPenjualan;

public class TesMainTrDetail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		TrDetailPenjualanSvc svc = ctx.getBean(TrDetailPenjualanSvc.class);
		List<TrDetailPenjualan> list = svc.findByHeader("TR001");
		for (TrDetailPenjualan tr : list) {
			System.out.println(tr.getHargaSatuan());	
		}
		
//		TrDetailPenjualan list2 = svc.findOne("dsada");
//		System.out.println(list2.getHargaSatuan());
				
	}
}
