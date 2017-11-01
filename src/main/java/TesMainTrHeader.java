import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.TrDetailPenjualanSvc;
import service.TrHeaderPenjualanSvc;
import dao.MstKaryawanDao;
import entity.MstKaryawan;
import entity.TrDetailPenjualan;
import entity.TrHeaderPenjualan;

public class TesMainTrHeader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");
		TrDetailPenjualanSvc mstKaryawanDao = ctx
				.getBean(TrDetailPenjualanSvc.class);

		// TES FINDALL() KARYAWAN
		List<TrDetailPenjualan> lisKaryawan = mstKaryawanDao.findAll();;
		for (TrDetailPenjualan k : lisKaryawan) {
			System.out.println("data karyawan:");
			System.out.println("Kode: " + k.getHargaSatuan());
			System.out.println("Nama Karyawan: " + k.getNoNota());
			System.out.println("Username: " + k.getQty());
			System.out.println("Password: "
					+ k.getKodeBarang().getNamaBarang());
		}

	}
}
