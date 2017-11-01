package vmd;

import oracle.jdbc.driver.Message;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;

public class tesBindVmd {
	private String nama;
	private double alas;
	private double tinggi;
	private double luas;
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public double getAlas() {
		return alas;
	}
	public void setAlas(double alas) {
		this.alas = alas;
	}
	public double getTinggi() {
		return tinggi;
	}
	public void setTinggi(double tinggi) {
		this.tinggi = tinggi;
	}
	public double getLuas() {
		return luas;
	}
	public void setLuas(double luas) {
		this.luas = luas;
	}
	
	@Command("hitung")
	
	@NotifyChange("luas")
	public void hitungLuas(){
		luas = 0.5*alas*tinggi;
		Messagebox.show("Luas Segitiga Adalah " + luas);
	}
	@Command("kliks")
	public void klik(){
		Messagebox.show("anda Menuliskan kata" + nama);
	}
	
}
