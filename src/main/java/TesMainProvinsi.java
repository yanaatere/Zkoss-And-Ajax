import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.MstKaryawanDao;
import dao.MstProvinsiDao;
import entity.MstProvinsi;
import entity.MstProvinsi;

public class TesMainProvinsi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		MstProvinsiDao mstProvinsiDao  = ctx.getBean(MstProvinsiDao.class);
		
		//TES SAVE PROVINSI
//		MstProvinsi mstProvinsi = new MstProvinsi();
//		mstProvinsi.setKodeProvinsi("P004");
//		mstProvinsi.setNamaProvinsi("JAWA TIMUR");
//		mstProvinsiDao.save(mstProvinsi);
		
		//TES FINDALL() PROVINSI
//		List<MstProvinsi> listProvinsi = mstProvinsiDao.findAll();
//		for (MstProvinsi k : listProvinsi) {
//			System.out.println("data provinsi:");
//			System.out.println("Kode: " + k.getKodeProvinsi());
//			System.out.println("Nama Provinsi: " + k.getNamaProvinsi());
//		}
		
		//TES FINDONE() PROVINSI
//		MstProvinsi mstProvinsi = mstProvinsiDao.findOne("P004");
//		System.out.println("data karyawan:");
//		System.out.println("Kode: " + mstProvinsi.getKodeProvinsi());
//		System.out.println("Nama Karyawan: " + mstProvinsi.getNamaProvinsi());
		
		//TES UPDATE PROVINSI
//		MstProvinsi mstProvinsi = new MstProvinsi();
//		mstProvinsi.setKodeProvinsi("P004");
//		mstProvinsi.setNamaProvinsi("BALI");
//		mstProvinsiDao.update(mstProvinsi);
//		System.out.println("data karyawan:");
//		System.out.println("Kode: " + mstProvinsi.getKodeProvinsi());
//		System.out.println("Nama Karyawan: " + mstProvinsi.getNamaProvinsi());

		//TES DELETE KARYAWAN
//		mstProvinsiDao.delete("P004");
//		List<MstProvinsi> listProvinsi = mstProvinsiDao.findAll();
//		for (MstProvinsi k : listProvinsi) {
//			System.out.println("data karyawan:");
//			System.out.println("Kode: " + k.getKodeProvinsi());
//			System.out.println("Nama Karyawan: " + k.getNamaProvinsi());
//		}
	}

}
