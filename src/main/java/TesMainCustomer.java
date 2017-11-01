import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MstCustomerSvc;
import service.MstKaryawanSvc;
import dao.MstCustomerDao;
import dao.MstKaryawanDao;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.MstKota;

public class TesMainCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		MstCustomerSvc mstCustomerDao  = ctx.getBean(MstCustomerSvc.class);
		
		//TES SAVE KARYAWAN
//		MstKaryawan mstKaryawan = new MstKaryawan();
//		  mstKaryawan.setKodeKaryawan("KR007");
//		  mstKaryawan.setNamaKaryawan("coy1");
//		  mstKaryawan.setUsername("admin2");
//		  mstKaryawan.setPassword("admin3");
//		  mstKaryawanDao.save(mstKaryawan);
		  
		//TES FINDALL() KARYAWAN
//		List<MstCustomer> lisCustomers = mstCustomerDao.findAll();
//		for (MstCustomer k : lisCustomers) {
//			System.out.println("data karyawan:");
//			System.out.println("Kode: " + k.getKodeCustomer());
//			System.out.println("Nama Kustomer: " + k.getNamaCustomer());
//			System.out.println("Alamat: " + k.getAlamatCustomer());
//			System.out.println("Email: " + k.getEmailCustomer());
//			System.out.println("Kode: " + k.getKodeKota().getKodeKota());
//		}
		
		//TES FINDONE() KARYAWAN
//		MstKaryawan mstKaryawan = mstKaryawanDao.findone("k003");
//		System.out.println("data karyawan:");
//		System.out.println("Kode: " + mstKaryawan.getKodeKaryawan());
//		System.out.println("Nama Karyawan: " + mstKaryawan.getNamaKaryawan());
//		System.out.println("Username: " + mstKaryawan.getUsername());
//		System.out.println("Password: " + mstKaryawan.getPassword());
		
		//TES UPDATE KARYAWAN// Apabila ada table yang berelasi maka harus di set terlebih dahulu
		MstKota mstKota = new MstKota();
		mstKota.setKodeKota("K001");
		MstCustomer customer = new MstCustomer();
		customer.setKodeCustomer("B467");
		customer.setNamaCustomer("Andika");
		customer.setKodeKota(mstKota);
		
		mstCustomerDao.update(customer);
		System.out.println("data karyawan:");
		System.out.println("Kode: " + customer.getNamaCustomer());
		
		
		//TES DELETE KARYAWAN
//		mstKaryawanDao.delete("KR003");
//		List<MstKaryawan> lisKaryawan = mstKaryawanDao.findAll();
//		for (MstKaryawan k : lisKaryawan) {
//			System.out.println("data karyawan:");
//			System.out.println("Kode: " + k.getKodeKaryawan());
//			System.out.println("Nama Karyawan: " + k.getNamaKaryawan());
//			System.out.println("Username: " + k.getUsername());
//			System.out.println("Password: " + k.getPassword());
//		}
	}

}
