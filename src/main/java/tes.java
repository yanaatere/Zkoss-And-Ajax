import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MstCustomerSvc;
import service.MstKaryawanSvc;
import dao.MstBarangDao;
import dao.MstCustomerDao;
import dao.MstKaryawanDao;
import dao.MstKotaDao;
import dao.impl.MstKaryawanDaoImpl;
import entity.MstBarang;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.MstKota;

public class tes {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");
		MstBarangDao mstKaryawandao = ctx.getBean(MstBarangDao.class);
		MstBarang mst = new MstBarang();
		mst.setKodeBarang("b44");
		mst.setStokBarang(20);
		mstKaryawandao.updateStok(mst);
//		MstKotaDao mstKotaDao = ctx.getBean(MstKotaDao.class);
//		List<MstKota> list = mstKotaDao.findAll();
//		for (MstKota mst : list) {
//			System.out.println(mst.getNamaKota());
//			System.out.println(mst.getKodeProvinsi().getNamaProvinsi());
//			System.out.println(mst.getKodeProvinsi().getKodeProvinsi());
//		}
//		
//		MstCustomerSvc mstCustomerDao = ctx.getBean(MstCustomerSvc.class);
//		List<MstCustomer> list = mstCustomerDao.findAll();
//		for (MstCustomer mstCustomer : list) {
//			System.out.println(mstCustomer.getKodeKota().getNamaKota());
//			System.out.println(mstCustomer.getEmailCustomer());
//			
//		}

		
//		  MstKaryawan mstKaryawan = new MstKaryawan();
//		  mstKaryawan.setKodeKaryawan("KR003");
//		  mstKaryawan.setNamaKaryawan("coy");
//		  mstKaryawan.setUsername("admin");
//		  mstKaryawan.setPassword("admin");
//		  mstKaryawandao.save(mstKaryawan);
		 

		/**
		 * Ini Untuk Melihat Semua Data List<MstKaryawan> listKaryawan =
		 * mstKaryawandao.findAll(); System.out.println(listKaryawan); for
		 * (MstKaryawan kasryawan : listKaryawan) {
		 * System.out.println("Daftar Karyawan"); System.out.print("Kode " +
		 * kasryawan.getKodeKaryawan()); System.out.print("Nama " +
		 * kasryawan.getNamaKaryawan()); System.out.print("Username " +
		 * kasryawan.getUsername()); System.out.print("Password " +
		 * kasryawan.getPassword()); }
		 */

		/**
		 * Delete
		 * MstKaryawan mstKaryawan = new MstKaryawan();
		 * mstKaryawan.setKodeKaryawan("KR003"); mstKaryawandao.delete("KR003");
		 */
//		MstKaryawan mstKaryawan = new MstKaryawan();
//		mstKaryawan.setNamaKaryawan("Yana Andika");
//		mstKaryawan.setUsername("retere");
//		mstKaryawan.setPassword("lamakau");
//		mstKaryawan.setKodeKaryawan("k001");
//		mstKaryawandao.update(mstKaryawan);
			
	}

}
