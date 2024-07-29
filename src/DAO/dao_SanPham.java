/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.dto_SanPham;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Tran Viet Phuc
 */
public class dao_SanPham {

    public static ArrayList<dto_SanPham> getListSanPham() {
        ArrayList<dto_SanPham> ds = new ArrayList<dto_SanPham>();
        try {
            String sql = "SELECT * FROM sanpham";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);

            while (rs.next()) {
                dto_SanPham clsp = new dto_SanPham();
                clsp.setMaSanPham(rs.getString("masanpham"));
                clsp.setTenSanPham(rs.getString("tensanpham"));
                clsp.setGiaBan(rs.getDouble("giaban"));
                clsp.setSoLuong(rs.getInt("soluong"));
                clsp.setMoTa(rs.getString("mota"));
                clsp.setMaMauSac(rs.getString("mamausac"));

                clsp.setSize(rs.getInt("size"));
                clsp.setHinhAnh(rs.getString("hinhanh"));
                clsp.setMaLoaiSanPham(rs.getString("maloaisanpham"));
                clsp.setMaThuongHieu(rs.getString("mathuonghieu"));
                ds.add(clsp);
            }
            helper.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
    }

    public dto_SanPham getSanPhamById(String maSanPham) {
        dto_SanPham sanPham = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM sanpham WHERE masanpham = ?";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            conn = helper.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maSanPham);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                sanPham = new dto_SanPham();
                sanPham.setMaSanPham(rs.getString("masanpham"));
                sanPham.setTenSanPham(rs.getString("tensanpham"));
                sanPham.setGiaBan(rs.getDouble("giaban"));
                sanPham.setSoLuong(rs.getInt("soluong"));
                sanPham.setMoTa(rs.getString("mota"));
                sanPham.setMaMauSac(rs.getString("mamausac"));
                sanPham.setSize(rs.getInt("size"));
                sanPham.setHinhAnh(rs.getString("hinhanh"));
                sanPham.setMaLoaiSanPham(rs.getString("maloaisanpham"));
                sanPham.setMaThuongHieu(rs.getString("mathuonghieu"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return sanPham;
    }

    public void themSanPham(dto_SanPham sanPham) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO sanpham (masanpham, tensanpham, giaban, soluong, maloaisanpham, mathuonghieu, mamauSac, size, mota, hinhanh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            conn = helper.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sanPham.getMaSanPham());
            pstmt.setString(2, sanPham.getTenSanPham());
            pstmt.setDouble(3, sanPham.getGiaBan());
            pstmt.setInt(4, sanPham.getSoLuong());
            pstmt.setString(5, sanPham.getMaLoaiSanPham());
            pstmt.setString(6, sanPham.getMaThuongHieu());
            pstmt.setString(7, sanPham.getMaMauSac());
            pstmt.setInt(8, sanPham.getSize());
            pstmt.setString(9, sanPham.getMoTa());
            pstmt.setString(10, sanPham.getHinhAnh());

            pstmt.executeUpdate();
            helper.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean xoaSanPham(String maSanPham) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "DELETE FROM sanpham WHERE masanpham = ?";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            conn = helper.getConnection();
            pstmt = conn.prepareStatement(sql);

            // Bind giá trị vào câu lệnh SQL
            pstmt.setString(1, maSanPham);

            // Thực thi câu lệnh DELETE
            int rowsAffected = pstmt.executeUpdate();

            // Nếu có ít nhất một hàng được ảnh hưởng, trả về true
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi SQL: " + ex.getMessage());
        } finally {
            // Đóng kết nối và tuyên bố PreparedStatement
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Lỗi khi đóng kết nối: " + ex.getMessage());
            }
        }
        // Nếu không có bất kỳ hàng nào được ảnh hưởng, hoặc có lỗi xảy ra, trả về false
        return false;
    }

    public void capNhatSanPham(dto_SanPham sanPham) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "UPDATE sanpham SET tensanpham = ?, giaban = ?, soluong = ?, maloaisanpham = ?, mathuonghieu = ?, mamauSac = ?, size = ?, mota = ?, hinhanh = ? WHERE masanpham = ?";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            conn = helper.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sanPham.getTenSanPham());
            pstmt.setDouble(2, sanPham.getGiaBan());
            pstmt.setInt(3, sanPham.getSoLuong());
            pstmt.setString(4, sanPham.getMaLoaiSanPham());
            pstmt.setString(5, sanPham.getMaThuongHieu());
            pstmt.setString(6, sanPham.getMaMauSac());
            pstmt.setInt(7, sanPham.getSize());
            pstmt.setString(8, sanPham.getMoTa());
            pstmt.setString(9, sanPham.getHinhAnh());
            pstmt.setString(10, sanPham.getMaSanPham());

            pstmt.executeUpdate();
            helper.close();
            System.out.println("Sản phẩm đã được cập nhật thành công.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Lỗi khi cập nhật sản phẩm: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Lỗi khi đóng kết nối: " + ex.getMessage());
            }
        }
    }

}
