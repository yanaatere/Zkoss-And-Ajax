package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstKotaDao;
import dao.MstProvinsiDao;
import entity.MstKota;
import entity.MstProvinsi;
import service.MstKotaSvc;

@Service("mstKotaSvc")
public class MstKotaSvcImpl implements MstKotaSvc {

	@Autowired
	private MstKotaDao mstKotaDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MstProvinsiDao mstProvinsiDao;
	private MstProvinsi mstProvinsi;
	
	@Override
	public List<MstKota> findAllData() {
		// TODO Auto-generated method stub
		return mstKotaDao.findAll();
	}

	@Override
	public void save(MstKota mstKota) {
		// TODO Auto-generated method stub
		mstKotaDao.save(mstKota);
	}

	@Override
	public void update(MstKota mstKota) {
		// TODO Auto-generated method stub
		mstKotaDao.update(mstKota);
	}

	@Override
	public void delete(String kodeKota) {
		// TODO Auto-generated method stub
		mstKotaDao.delete(kodeKota);
	}

	@Override
	public MstKota findOne(String kodeKota) {
		// TODO Auto-generated method stub
		return mstKotaDao.findone(kodeKota);
	}

	@Override
	public List<MstKota> findKota(String kodeProvinsi) {
		// TODO Auto-generated method stub
		String query = "select kode_kota, nama_kota, kode_provinsi from mst_kota where kode_provinsi=?";
		List<MstKota> listKota = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeProvinsi);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstKota mstKota = new MstKota();
				
				mstKota.setKodeKota((rs.getString("kode_kota")));
				mstKota.setNamaKota((rs.getString("nama_kota")));
				kodeProvinsi = (rs.getString("kode_provinsi"));
				mstProvinsi = mstProvinsiDao.findone(kodeProvinsi);
				mstKota.setKodeProvinsi(mstProvinsi);
				listKota.add(mstKota);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return listKota;
	}


}
