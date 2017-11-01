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

import dao.MstBarangDao;
import dao.MstSupplierDao;
import entity.MstBarang;
import entity.MstSupplier;

@Repository
public class MstBarangDaoImpl implements MstBarangDao {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MstSupplierDao mstSupplierDao;
	private MstSupplier mstSupplier;
	private String kodeSupplier;

	@Override
	public void save(MstBarang mstBarang) {
		// TODO Auto-generated method stub
		String query = "insert into Mst_barang"
				+ "(kode_barang, nama_barang, stok_barang, kode_supplier)" + "values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstBarang.getKodeBarang());
			ps.setString(2, mstBarang.getNamaBarang());
			ps.setInt(3, mstBarang.getStokBarang());
			ps.setString(4, mstBarang.getKodeSupplier().getKodeSupplier());

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
	public void update(MstBarang mstBarang) {
		// TODO Auto-generated method stub
		String query = "update Mst_barang set nama_barang=?, stok_barang=?, kode_supplier=? where kode_barang=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(4, mstBarang.getKodeBarang());
			ps.setString(1, mstBarang.getNamaBarang());
			ps.setInt(2, mstBarang.getStokBarang());
			ps.setString(3, mstBarang.getKodeSupplier().getKodeSupplier());

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
	public void delete(String kodeBarang) {
		// TODO Auto-generated method stub
		String query = "delete from mst_barang where kode_barang=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeBarang);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("karyawan deleted with id=" + kodeBarang);
			} else {
				System.out.println("No karyawan found with id=" + kodeBarang);
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
	public List<MstBarang> findAll() {
		// TODO Auto-generated method stub
		String query = "select * from mst_barang";
		List<MstBarang> listBarang = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstBarang mstBarang = new MstBarang();
				
				mstBarang.setKodeBarang(rs.getString("kode_barang"));
				mstBarang.setNamaBarang(rs.getString("nama_barang"));
				Integer string = Integer.parseInt(rs.getString("stok_barang"));
				mstBarang.setStokBarang(string);
				kodeSupplier = (rs.getString("kode_supplier"));
				mstSupplier = mstSupplierDao.findOne(kodeSupplier);
				mstBarang.setKodeSupplier(mstSupplier);
				listBarang.add(mstBarang);
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
		return listBarang;
	}

	@Override
	public MstBarang findOne(String kodeBarang) {
		// TODO Auto-generated method stub
		String query = "select * from mst_barang where kode_barang='"+kodeBarang+"'";
		MstBarang mstBarang = new MstBarang();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstBarang.setKodeBarang(rs.getString("kode_barang"));
				mstBarang.setNamaBarang(rs.getString("nama_barang"));
				Integer string = Integer.parseInt(rs.getString("stok_barang"));
				mstBarang.setStokBarang(string);
				mstBarang.setStokBarang(string);
				kodeSupplier = (rs.getString("kode_supplier"));
				mstSupplier = mstSupplierDao.findOne(kodeSupplier);
				mstBarang.setKodeSupplier(mstSupplier);
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
		return mstBarang;
	}

	@Override
	public void updateStok(MstBarang mstBarang) {
		String query = "UPDATE MST_BARANG SET [STOK_BARANG] = ?"
				+" WHERE KODE_BARANG = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, mstBarang.getStokBarang());
			ps.setString(2, mstBarang.getKodeBarang());
			

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

}
