package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.MstCustomerDao;
import dao.MstKaryawanDao;
import dao.TrHeaderPenjualanDao;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.TrHeaderPenjualan;

@Repository
public class TrHeaderPenjualanDaoImpl implements TrHeaderPenjualanDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private MstKaryawanDao mstKaryawanDao;
	private MstKaryawan mstKaryawan;
	private String kodeKaryawan;

	@Autowired
	private MstCustomerDao mstCustomerDao;
	private MstCustomer mstCustomer;
	private String kodeCustomer;

	@Override
	public void save(TrHeaderPenjualan trHeaderPenjualan) {
		// TODO Auto-generated method stub
		String query = "insert into TR_HEADER_PENJUALAN"
				+ "(NO_NOTA,TANGGAL_TRANSAKSI,HARGA_TOTAL,GLOBAL_DISKON,KODE_CUSTOMER,KODE_KARYAWAN)"
				+ "values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, trHeaderPenjualan.getNoNota());
			ps.setDate(2, trHeaderPenjualan.getTanggalTransaksi());
			ps.setInt(3, trHeaderPenjualan.getHargaTotal());
			ps.setInt(4, trHeaderPenjualan.getGlobalDiskon());
			ps.setString(5, trHeaderPenjualan.getKodeCustomer()
					.getKodeCustomer());
			ps.setString(6, trHeaderPenjualan.getKodeKaryawan()
					.getKodeKaryawan());

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
	public void update(TrHeaderPenjualan trHeaderPenjualan) {
		// TODO Auto-generated method stub
		String query = "update TR_HEADER_PENJUALAN set TANGGAL_TRANSAKSI=? ,HARGA_TOTAL=? ,GLOBAL_DISKON=? ,KODE_CUSTOMER=? ,KODE_KARYAWAN=? where no_nota=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(6, trHeaderPenjualan.getNoNota());
			ps.setDate(1, trHeaderPenjualan.getTanggalTransaksi());
			ps.setInt(2, trHeaderPenjualan.getHargaTotal());
			ps.setInt(3, trHeaderPenjualan.getGlobalDiskon());
			ps.setString(4, trHeaderPenjualan.getKodeCustomer()
					.getKodeCustomer());
			ps.setString(5, trHeaderPenjualan.getKodeKaryawan()
					.getKodeKaryawan());

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
	public void delete(String noNota) {
		// TODO Auto-generated method stub
		String query = "delete from TR_HEADER_PENJUALAN where no_nota=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, noNota);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("delete berhasil");
			} else {
				System.out.println("not found");
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
	public List<TrHeaderPenjualan> findAll() {
		// TODO Auto-generated method stub
		String query = "select * from TR_HEADER_PENJUALAN";
		List<TrHeaderPenjualan> listHeader = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				TrHeaderPenjualan trHeader = new TrHeaderPenjualan();
				trHeader.setNoNota(rs.getString("no_nota"));
				Date date = Date.valueOf(rs.getString("tanggal_transaksi"));
				trHeader.setTanggalTransaksi(date);
				trHeader.setHargaTotal(rs.getInt("harga_total"));
				trHeader.setGlobalDiskon(rs.getInt("global_diskon"));
				kodeCustomer = (rs.getString("kode_customer"));
				mstCustomer = mstCustomerDao.findOne(kodeCustomer);
				trHeader.setKodeCustomer(mstCustomer);
				kodeKaryawan = (rs.getString("kode_karyawan"));
				mstKaryawan = mstKaryawanDao.findone(kodeKaryawan);
				trHeader.setKodeKaryawan(mstKaryawan);
				listHeader.add(trHeader);
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
		return listHeader;
	}

	@Override
	public TrHeaderPenjualan findOne(String noNota) {
		// TODO Auto-generated method stub
		String query = "select * from TR_HEADER_PENJUALAN where no_nota='"
				+ noNota + "'";
		TrHeaderPenjualan trHeader = new TrHeaderPenjualan();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				trHeader.setNoNota(rs.getString("no_nota"));
				Date date = Date.valueOf(rs.getString("tanggal_transaksi"));
				trHeader.setTanggalTransaksi(date);
				trHeader.setHargaTotal(rs.getInt("harga_total"));
				trHeader.setGlobalDiskon(rs.getInt("global_diskon"));
				kodeCustomer = (rs.getString("kode_customer"));
				mstCustomer = mstCustomerDao.findOne(kodeCustomer);
				trHeader.setKodeCustomer(mstCustomer);
				kodeKaryawan = (rs.getString("kode_karyawan"));
				mstKaryawan = mstKaryawanDao.findone(kodeKaryawan);
				trHeader.setKodeKaryawan(mstKaryawan);
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
		return trHeader;
	}

	@Override
	public void deletedetail(String noNota) {
		String query = "delete from TR_DETAIL_PENJUALAN where no_nota=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, noNota);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("delete berhasil");
			} else {
				System.out.println("not found");
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
	public List<TrHeaderPenjualan> Search(String search) {
		String query = "select * from TR_HEADER_PENJUALAN WHERE NO_NOTA LIKE '%"+search+"%'";
		List<TrHeaderPenjualan> listHeader = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				TrHeaderPenjualan trHeader = new TrHeaderPenjualan();
				trHeader.setNoNota(rs.getString("no_nota"));
				Date date = Date.valueOf(rs.getString("tanggal_transaksi"));
				trHeader.setTanggalTransaksi(date);
				trHeader.setHargaTotal(rs.getInt("harga_total"));
				trHeader.setGlobalDiskon(rs.getInt("global_diskon"));
				kodeCustomer = (rs.getString("kode_customer"));
				mstCustomer = mstCustomerDao.findOne(kodeCustomer);
				trHeader.setKodeCustomer(mstCustomer);
				kodeKaryawan = (rs.getString("kode_karyawan"));
				mstKaryawan = mstKaryawanDao.findone(kodeKaryawan);
				trHeader.setKodeKaryawan(mstKaryawan);
				listHeader.add(trHeader);
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
		return listHeader;
		
	}
}