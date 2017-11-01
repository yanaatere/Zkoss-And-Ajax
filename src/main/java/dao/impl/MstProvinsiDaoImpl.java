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
import org.w3c.dom.ls.LSInput;

import dao.MstProvinsiDao;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.MstKota;
import entity.MstProvinsi;

@Repository
public class MstProvinsiDaoImpl implements MstProvinsiDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public void save(MstProvinsi mstProvinsi) {
		String query = "INSERT INTO MST_PROVINSI (KODE_PROVINSI ,NAMA_PROVINSI)"
				+ " VALUES (?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstProvinsi.getKodeProvinsi());
			ps.setString(2, mstProvinsi.getNamaProvinsi());
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
	public void update(MstProvinsi mstProvinsi) {
		String query = "UPDATE dbo.MST_PROVINSI SET NAMA_PROVINSI = ?"
				+ " WHERE KODE_PROVINSI = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstProvinsi.getNamaProvinsi());
			ps.setString(2, mstProvinsi.getKodeProvinsi());
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
	public void delete(String kodeProvinsi) {
		String query = "DELETE FROM MST_PROVINSI WHERE KODE_PROVINSI = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeProvinsi);
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Provinsi Delete with Id = " + kodeProvinsi);

			} else {
				System.out.println("No Provinsi Delete with Id = "
						+ kodeProvinsi);
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
	public List<MstProvinsi> findAll() {
		String query = "SELECT * FROM MST_PROVINSI";
		List<MstProvinsi> listProvins = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstProvinsi mstProvinsi = new MstProvinsi();
				mstProvinsi.setKodeProvinsi(rs.getString("KODE_PROVINSI"));
				mstProvinsi.setNamaProvinsi(rs.getString("NAMA_PROVINSI"));
				listProvins.add(mstProvinsi);
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
		return listProvins;
	}

	@Override
	public MstProvinsi findone(String kodeProvinsi) {
		String query = "SELECT KODE_PROVINSI ,NAMA_PROVINSI FROM MST_PROVINSI WHERE KODE_PROVINSI = '"+kodeProvinsi+"'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstProvinsi mstProvinsi = new MstProvinsi();
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstProvinsi.setKodeProvinsi(rs.getString("KODE_PROVINSI"));
				mstProvinsi.setNamaProvinsi(rs.getString("NAMA_PROVINSI"));
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
		return mstProvinsi;
	}

}
