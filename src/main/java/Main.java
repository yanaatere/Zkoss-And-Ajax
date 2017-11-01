import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.MstBarang;
import service.MstBarangSvc;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		MstBarangSvc barang = ctx.getBean(MstBarangSvc.class);
		MstBarang br = barang.findOne("b44");
		System.out.println(br.getStokBarang());
	}

}
