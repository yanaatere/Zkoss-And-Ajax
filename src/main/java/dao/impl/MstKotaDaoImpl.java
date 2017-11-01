package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.MstKotaDao;
import dao.MstProvinsiDao;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.MstKota;
import entity.MstProvinsi;

@Repository
public class MstKotaDaoImpl implements MstKotaDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	MstProvinsiDao mstProvinsiDao;

	@Override
	public void save(MstKota mstKota) {
		String query = "INSERT INTO dbo.MST_KOTA (KODE_KOTA,NAMA_KOTA,KODE_PROVINSI)"
				+ " VALUES (?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstKota.getKodeKota());
			ps.setString(2, mstKota.getNamaKota());
			ps.setString(3, mstKota.getKodeProvinsi().getKodeProvinsi());
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Sukses");
			} else {
				System.out.println("Failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(MstKota mstKota) {
		String query = "UPDATE MST_KOTA SET NAMA_KOTA = ? ,KODE_PROVINSI = ?"
				+ " WHERE KODE_KOTA = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstKota.getNamaKota());
			ps.setString(2, mstKota.getKodeProvinsi().getKodeProvinsi());
			ps.setString(3, mstKota.getKodeKota());
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Sukses");
			} else {
				System.out.println("Failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(String kodeKota) {
		String query = "DELETE FROM MST_KOTA WHERE KODE_KOTA = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeKota);
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Kota Delete with Id = " + kodeKota);

			} else {
				System.out.println("No Kota Delete with Id = " + kodeKota);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<MstKota> findAll() {
		String query = "SELECT * FROM MST_KOTA";
		List<MstKota> listKota = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstKota mstKota = new MstKota();
				mstKota.setKodeKota(rs.getString("KODE_KOTA"));
				mstKota.setNamaKota(rs.getString("NAMA_KOTA"));
				MstProvinsi provinsi = mstProvinsiDao.findone(rs
						.getString("KODE_PROVINSI"));
				mstKota.setKodeProvinsi(provinsi);
				listKota.add(mstKota);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listKota;
	}

	@Override
	public MstKota findone(String kodeKota) {
		String query = "SELECT KODE_KOTA ,NAMA_KOTA,KODE_PROVINSI"
				+ " FROM MST_KOTA WHERE KODE_KOTA = '"+kodeKota+"'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstKota mstKota = new MstKota();
		MstProvinsi mstProvinsi = new  MstProvinsi();
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstKota.setKodeKota(rs.getString("KODE_KOTA"));
				mstKota.setNamaKota(rs.getString("NAMA_KOTA"));
				mstProvinsi.setKodeProvinsi(rs.getString("KODE_PROVINSI"));
				mstKota.setKodeProvinsi(mstProvinsi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mstKota;
	}
}
