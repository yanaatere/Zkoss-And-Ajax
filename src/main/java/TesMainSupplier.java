import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.MstKaryawanDao;
import dao.MstSupplierDao;
import entity.MstKaryawan;
import entity.MstSupplier;

public class TesMainSupplier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		MstSupplierDao mstSupplierDao  = ctx.getBean(MstSupplierDao.class);
		
		List<MstSupplier> list = mstSupplierDao.findAll();
		for (MstSupplier mstSupplier : list) {
			System.out.println(mstSupplier.getNamaSupplier());
		}
		
	}

}
