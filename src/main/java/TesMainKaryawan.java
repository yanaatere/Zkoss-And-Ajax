import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MstKaryawanSvc;
import dao.MstKaryawanDao;
import entity.MstKaryawan;

public class TesMainKaryawan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		MstKaryawanSvc mstKaryawanDao  = ctx.getBean(MstKaryawanSvc.class);
		
		//TES SAVE KARYAWAN
//		MstKaryawan mstKaryawan = new MstKaryawan();
//		mstKaryawan.setKodeKaryawan("KR003");
//		mstKaryawan.setNamaKaryawan("Yana");
//		mstKaryawan.setUsername("admin");
//		mstKaryawan.setPassword("admin");
//		mstKaryawanDao.save(mstKaryawan);
		
		//TES FINDALL() KARYAWAN
		List<MstKaryawan> lisKaryawan = mstKaryawanDao.findAll();
		for (MstKaryawan k : lisKaryawan) {
			System.out.println("data karyawan:");
			System.out.println("Kode: " + k.getKodeKaryawan());
			System.out.println("Nama Karyawan: " + k.getNamaKaryawan());
			System.out.println("Username: " + k.getUsername());
			System.out.println("Password: " + k.getPassword());
//		}
		
		//TES FINDONE() KARYAWAN
//		MstKaryawan mstKaryawan = mstKaryawanDao.findOne("KR003");
//		System.out.println("data karyawan:");
//		System.out.println("Kode: " + mstKaryawan.getKodeKaryawan());
//		System.out.println("Nama Karyawan: " + mstKaryawan.getNamaKaryawan());
//		System.out.println("Username: " + mstKaryawan.getUsername());
//		System.out.println("Password: " + mstKaryawan.getPassword());
		
		//TES UPDATE KARYAWAN
//		MstKaryawan mstKaryawan = new MstKaryawan();
//		mstKaryawan.setKodeKaryawan("KR003");
//		mstKaryawan.setNamaKaryawan("Yana");
//		mstKaryawan.setUsername("admin");
//		mstKaryawan.setPassword("admin");
//		mstKaryawanDao.update(mstKaryawan);
//		System.out.println("data karyawan:");
//		System.out.println("Kode: " + mstKaryawan.getKodeKaryawan());
//		System.out.println("Nama Karyawan: " + mstKaryawan.getNamaKaryawan());
//		System.out.println("Username: " + mstKaryawan.getUsername());
//		System.out.println("Password: " + mstKaryawan.getPassword());

		//TES DELETE KARYAWAN
//		mstKaryawanDao.delete("KR003");
//		List<MstKaryawan> lisKaryawan = mstKaryawanDao.findAll();
//		for (MstKaryawan k : lisKaryawan) {
//			System.out.println("data karyawan:");
//			System.out.println("Kode: " + k.getKodeKaryawan());
//			System.out.println("Nama Karyawan: " + k.getNamaKaryawan());
//			System.out.println("Username: " + k.getUsername());
//			System.out.println("Password: " + k.getPassword());
		}
	}

}
