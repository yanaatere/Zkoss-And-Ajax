import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MstKotaSvc;
import service.MstProvinsiSvc;
import dao.MstKaryawanDao;
import dao.MstKotaDao;
import dao.MstProvinsiDao;
import entity.MstKaryawan;
import entity.MstKota;
import entity.MstProvinsi;

public class TesMainKota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		MstKotaSvc mstKotaSvc  = ctx.getBean(MstKotaSvc.class);
		MstProvinsiSvc mstProvinsiSvc = ctx.getBean(MstProvinsiSvc.class);
		
		//TES SAVE KOTA
//		MstKota mstKota = new MstKota();
//		MstProvinsi mstProvinsi = mstProvinsiSvc.findOne("P002");
//		mstKota.setKodeKota("K008");
//		mstKota.setNamaKota("Klaten");
//		mstKota.setKodeProvinsi(mstProvinsi);
//		mstKotaSvc.save(mstKota);
		
		//TES FINDALL() KOTA
//		List<MstKota> listKota = mstKotaSvc.findAllData();
//		for (MstKota k : listKota) {
//			System.out.println("data kota:");
//			System.out.println("Kode: " + k.getKodeKota());
//			System.out.println("Nama Kota: " + k.getNamaKota());
//			System.out.println("Kode Provinsi: " + k.getKodeProvinsi().getKodeProvinsi());
//		}
		
		//TES FINDONE() KOTA
		MstKota mstKota = mstKotaSvc.findOne("K007");
		System.out.println("data kota:");
		System.out.println("Kode: " + mstKota.getKodeKota());
		System.out.println("Nama Kota: " + mstKota.getNamaKota());
		System.out.println("Kode Provinsi: " + mstKota.getKodeProvinsi().getKodeProvinsi());
		
		//TES UPDATE KOTA
//		MstKota mstKota = new MstKota();
//		MstProvinsi mstProvinsi = mstProvinsiDao.findone("P002");
//		mstKota.setKodeKota("K007");;
//		mstKota.setNamaKota("Yogyakarta");;
//		mstKota.setKodeProvinsi(mstProvinsi);
//		mstKotaDao.update(mstKota);
//		System.out.println("data karyawan:");
//		System.out.println("Kode: " + mstKota.getKodeKota());
//		System.out.println("Nama Kota: " + mstKota.getNamaKota());
//		System.out.println("Kode Provinsi: " + mstKota.getKodeProvinsi().getKodeProvinsi());

//		//TES DELETE KOTA
//		mstKotaSvc.delete("K001");
//		List<MstKota> listKota = mstKotaSvc.findAllData();
//		for (MstKota k : listKota) {
//			System.out.println("data kota:");
//			System.out.println("Kode: " + k.getKodeKota());
//			System.out.println("Nama Kota: " + k.getNamaKota());
//			System.out.println("Kode Provinsi: " + k.getKodeProvinsi().getKodeProvinsi());
//		}
	}
	}
//	}

