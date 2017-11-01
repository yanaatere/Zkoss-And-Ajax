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

import dao.MstCustomerDao;
import dao.MstKotaDao;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.MstKota;

@Repository
public class MstCustomerDaoImpl implements MstCustomerDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	MstKotaDao mstKota;

	@Override
	public void save(MstCustomer mstCustomer) {
		String query = "INSERT INTO MST_CUSTOMER (KODE_CUSTOMER ,NAMA_CUSTOMER,ALAMAT_CUSTOMER,JENIS_KELAMIN,EMAIL_CUSTOMER,KODE_KOTA)"
				+ " VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstCustomer.getKodeCustomer());
			ps.setString(2, mstCustomer.getNamaCustomer());
			ps.setString(3, mstCustomer.getAlamatCustomer());
			ps.setString(4, mstCustomer.getJenisKelamin());
			ps.setString(5, mstCustomer.getEmailCustomer());
			ps.setString(6, mstCustomer.getKodeKota().getKodeKota());

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
	public void update(MstCustomer mstCustomer) {
		String query = "UPDATE MST_CUSTOMER SET"
				+ " NAMA_CUSTOMER = ?, ALAMAT_CUSTOMER = ?, JENIS_KELAMIN = ?, EMAIL_CUSTOMER = ?, KODE_KOTA = ?"
				+ " WHERE KODE_CUSTOMER = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstCustomer.getNamaCustomer());
			ps.setString(2, mstCustomer.getAlamatCustomer());
			ps.setString(3, mstCustomer.getJenisKelamin());
			ps.setString(4, mstCustomer.getEmailCustomer());
			ps.setString(5, mstCustomer.getKodeKota().getKodeKota());
			ps.setString(6, mstCustomer.getKodeCustomer());
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("update sukses");
			} else {
				System.out.println("update gagal");
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
	}

	@Override
	public void delete(String kodeCustomer) {
		String query = "DELETE FROM MST_CUSTOMER WHERE KODE_CUSTOMER = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeCustomer);
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Karyawan Delete with Id = " + kodeCustomer);

			} else {
				System.out.println("No Karyawan Delete with Id = "
						+ kodeCustomer);
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
	public List<MstCustomer> findAll() {
		String query = "SELECT * FROM MST_CUSTOMER";
		List<MstCustomer> listCustomer = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstCustomer mstCustomer = new MstCustomer();
				mstCustomer.setKodeCustomer(rs.getString("KODE_CUSTOMER"));
				mstCustomer.setNamaCustomer(rs.getString("NAMA_CUSTOMER"));
				mstCustomer.setAlamatCustomer(rs.getString("ALAMAT_CUSTOMER"));
				mstCustomer.setJenisKelamin(rs.getString("JENIS_KELAMIN"));
				mstCustomer.setEmailCustomer(rs.getString("EMAIL_CUSTOMER"));
				MstKota kota = mstKota.findone(rs.getString("KODE_KOTA"));
				mstCustomer.setKodeKota(kota);
				listCustomer.add(mstCustomer);
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
		return listCustomer;
	}

	@Override
	public MstCustomer findOne(String kodeCustomer) {
		String query = "SELECT * FROM dbo.MST_CUSTOMER where KODE_CUSTOMER = '"
				+ kodeCustomer + "'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstCustomer mstCustomer = new MstCustomer();
		MstKota mstKota = new MstKota();
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstCustomer.setKodeCustomer(rs.getString("KODE_CUSTOMER"));
				mstCustomer.setNamaCustomer(rs.getString("NAMA_CUSTOMER"));
				mstCustomer.setAlamatCustomer(rs.getString("ALAMAT_CUSTOMER"));
				mstCustomer.setJenisKelamin(rs.getString("JENIS_KELAMIN"));
				mstCustomer.setEmailCustomer(rs.getString("EMAIL_CUSTOMER"));
				mstKota.setKodeKota(rs.getString("KODE_KOTA"));
				mstCustomer.setKodeKota(mstKota);
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
		return mstCustomer;
	}

}
