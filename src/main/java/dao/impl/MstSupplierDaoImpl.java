package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MstKotaDao;
import dao.MstSupplierDao;
import entity.MstKota;
import entity.MstSupplier;

@Repository
public class MstSupplierDaoImpl implements MstSupplierDao {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MstKotaDao mstKotaDao;
	private MstKota mstKota;
	private String kodeKota;

	@Override
	public void save(MstSupplier mstSupplier) {
		// TODO Auto-generated method stub
		String query = "insert into Mst_supplier"
				+ "(kode_supplier, nama_supplier, alamat_supplier, telp_supplier, email_supplier, kode_kota)"
				+ "values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstSupplier.getKodeSupplier());
			ps.setString(2, mstSupplier.getNamaSupplier());
			ps.setString(3, mstSupplier.getAlamatSupplier());
			ps.setString(4, mstSupplier.getTelpSupplier());
			ps.setString(5, mstSupplier.getEmailSupplier());
			ps.setString(6, mstSupplier.getKodekota().getKodeKota());

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("sukses");
			} else {
				System.out.println("failed");
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
	public void update(MstSupplier mstSupplier) {
		// TODO Auto-generated method stub
		String query = "update Mst_supplier set nama_supplier=?, alamat_supplier=?, telp_supplier=?, email_supplier=?, kode_kota=? where kode_supplier=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(6, mstSupplier.getKodeSupplier());
			ps.setString(1, mstSupplier.getNamaSupplier());
			ps.setString(2, mstSupplier.getAlamatSupplier());
			ps.setString(3, mstSupplier.getTelpSupplier());
			ps.setString(4, mstSupplier.getEmailSupplier());
			ps.setString(5, mstSupplier.getKodekota().getKodeKota());

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
	public void delete(String kodeSupplier) {
		// TODO Auto-generated method stub
		String query = "delete from mst_supplier where kode_supplier=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeSupplier);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Delete Berhasil!");
			} else {
				System.out.println("Not Found");
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
	public List<MstSupplier> findAll() {
		// TODO Auto-generated method stub
		String query = "select * from mst_supplier";
		List<MstSupplier> listSuppliers = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstSupplier mstSupplier = new MstSupplier();
				
				mstSupplier.setKodeSupplier(rs.getString("kode_supplier"));
				mstSupplier.setNamaSupplier(rs.getString("nama_supplier"));
				mstSupplier.setAlamatSupplier(rs.getString("alamat_supplier"));
				mstSupplier.setTelpSupplier(rs.getString("telp_supplier"));
				mstSupplier.setEmailSupplier(rs.getString("email_supplier"));
				kodeKota = (rs.getString("kode_kota"));
				mstKota = mstKotaDao.findone(kodeKota);
				mstSupplier.setKodekota(mstKota);
				listSuppliers.add(mstSupplier);
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
		return listSuppliers;
	}

	@Override
	public MstSupplier findOne(String kodeSupplier) {
		// TODO Auto-generated method stub
		String query = "select * from mst_supplier where kode_supplier='"+kodeSupplier+"'";
		MstSupplier mstSupplier = new MstSupplier();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstSupplier.setKodeSupplier(rs.getString("kode_supplier"));
				mstSupplier.setNamaSupplier(rs.getString("nama_supplier"));
				mstSupplier.setAlamatSupplier(rs.getString("alamat_supplier"));
				mstSupplier.setTelpSupplier(rs.getString("telp_supplier"));
				mstSupplier.setEmailSupplier(rs.getString("email_supplier"));
				kodeKota = (rs.getString("kode_kota"));
				mstKota = mstKotaDao.findone(kodeKota);
				mstSupplier.setKodekota(mstKota);
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
		return mstSupplier;
	}

}
