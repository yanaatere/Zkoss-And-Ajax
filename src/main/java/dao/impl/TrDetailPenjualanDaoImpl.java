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

import dao.MstBarangDao;
import dao.TrDetailPenjualanDao;
import dao.TrHeaderPenjualanDao;
import entity.MstBarang;
import entity.TrDetailPenjualan;
import entity.TrHeaderPenjualan;

@Repository
public class TrDetailPenjualanDaoImpl implements TrDetailPenjualanDao{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MstBarangDao mstBarangDao;
	private MstBarang mstBarang;
	private String kodeBarang;
	
	@Autowired
	private TrHeaderPenjualanDao trHeaderPenjualanDao;
	private TrHeaderPenjualan trHeaderPenjualan;
	private String noNota;
	
	@Override
	public void save(TrDetailPenjualan trDetailPenjualan) {
		// TODO Auto-generated method stub
		String query = "insert into TR_DETAIL_PENJUALAN"
				+ "(KODE_DETAIL,QTY,SUBTOTAL,DISKON,HARGA_SATUAN,KODE_BARANG,NO_NOTA)"
				+ "values(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, trDetailPenjualan.getKodeDetail());
			ps.setInt(2, trDetailPenjualan.getQty());
			ps.setInt(3, trDetailPenjualan.getSubtotal());
			ps.setInt(4, trDetailPenjualan.getDiskon());
			ps.setInt(5, trDetailPenjualan.getHargaSatuan());
			ps.setString(6, trDetailPenjualan.getKodeBarang().getKodeBarang());
			ps.setString(7, trDetailPenjualan.getNoNota().getNoNota());

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
	public void update(TrDetailPenjualan trDetailPenjualan) {
		// TODO Auto-generated method stub
		String query = "update TR_DETAIL_PENJUALAN set QTY=?, SUBTOTAL=?, DISKON=?, HARGA_SATUAN=?, KODE_BARANG=?, NO_NOTA=? where kode_detail=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, trDetailPenjualan.getKodeDetail());
			ps.setInt(2, trDetailPenjualan.getQty());
			ps.setInt(3, trDetailPenjualan.getSubtotal());
			ps.setInt(4, trDetailPenjualan.getDiskon());
			ps.setInt(5, trDetailPenjualan.getHargaSatuan());
			ps.setString(6, trDetailPenjualan.getKodeBarang().getKodeBarang());
			ps.setString(7, trDetailPenjualan.getNoNota().getNoNota());

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
	public void delete(String kodeDetail) {
		// TODO Auto-generated method stub
		String query = "delete from TR_DETAIL_PENJUALAN where kode_detail=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeDetail);

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
	public List<TrDetailPenjualan> findAll() {
		// TODO Auto-generated method stub
		String query = "select * from TR_DETAIL_PENJUALAN";
		List<TrDetailPenjualan> listDetail = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				TrDetailPenjualan trDetail = new TrDetailPenjualan();
				trDetail.setKodeDetail(rs.getString("kode_detail"));
				trDetail.setQty(rs.getInt("Qty"));
				trDetail.setSubtotal(rs.getInt("subtotal"));
				trDetail.setDiskon(rs.getInt("diskon"));
				trDetail.setHargaSatuan(rs.getInt("harga_satuan"));
				kodeBarang = (rs.getString("kode_barang"));
				mstBarang = mstBarangDao.findOne(kodeBarang);
				trDetail.setKodeBarang(mstBarang);
				noNota = (rs.getString("no_nota"));
				trHeaderPenjualan = trHeaderPenjualanDao.findOne(noNota);
				trDetail.setNoNota(trHeaderPenjualan);
				listDetail.add(trDetail);
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
		return listDetail;
	}

	@Override
	public TrDetailPenjualan findOne(String kodeDetail) {
		// TODO Auto-generated method stub
		String query = "select * from TR_DETAIL_PENJUALAN where kode_detail= '"+kodeDetail+"'";
		TrDetailPenjualan trDetail = new TrDetailPenjualan();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				trDetail.setKodeDetail(rs.getString("kode_detail"));
				trDetail.setQty(rs.getInt("Qty"));
				trDetail.setSubtotal(rs.getInt("subtotal"));
				trDetail.setDiskon(rs.getInt("diskon"));
				trDetail.setHargaSatuan(rs.getInt("harga_satuan"));
				kodeBarang = (rs.getString("kode_barang"));
				mstBarang = mstBarangDao.findOne(kodeBarang);
				trDetail.setKodeBarang(mstBarang);
				noNota = (rs.getString("no_nota"));
				trHeaderPenjualan = trHeaderPenjualanDao.findOne(noNota);
				trDetail.setNoNota(trHeaderPenjualan);
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
		return trDetail;
	}

	@Override
	public List<TrDetailPenjualan> findByHeader(String noNota) {
		String query = "select * from TR_DETAIL_PENJUALAN WHERE NO_NOTA = '"+ noNota +"'";
		List<TrDetailPenjualan> listFindDetail = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				TrDetailPenjualan trDetail = new TrDetailPenjualan();
				trDetail.setKodeDetail(rs.getString("KODE_DETAIL"));
				trDetail.setQty(rs.getInt("QTY"));
				trDetail.setSubtotal(rs.getInt("SUBTOTAL"));
				trDetail.setDiskon(rs.getInt("DISKON"));
				trDetail.setHargaSatuan(rs.getInt("HARGA_SATUAN"));
				kodeBarang = (rs.getString("KODE_BARANG"));
				mstBarang = mstBarangDao.findOne(kodeBarang);
				trDetail.setKodeBarang(mstBarang);
				noNota = (rs.getString("NO_NOTA"));
				trHeaderPenjualan = trHeaderPenjualanDao.findOne(noNota);
				trDetail.setNoNota(trHeaderPenjualan);
				listFindDetail.add(trDetail);
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
		return listFindDetail;
	}

}
