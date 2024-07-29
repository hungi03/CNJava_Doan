/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.dto_LoaiSanPham;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author
 */
public class dao_LoaiSanPham {

    public static ArrayList<dto_LoaiSanPham> getListLoaiSanPham() {
        ArrayList<dto_LoaiSanPham> ds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM loaisanpham";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);

            while (rs.next()) {
                dto_LoaiSanPham cllsp = new dto_LoaiSanPham();
                cllsp.setMaLoaiSanPham(rs.getString("maloaisanpham"));
                cllsp.setTenLoaiSanPham(rs.getString("tenloaisanpham"));
                ds.add(cllsp);
            }
            helper.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
    }

    public dto_LoaiSanPham getLoaiSanPhamById(String maLoaiSanPham) {
        dto_LoaiSanPham loaiSanPham = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM loaisanpham WHERE maloaisanpham = ?";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            conn = helper.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maLoaiSanPham);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                loaiSanPham = new dto_LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(rs.getString("maloaisanpham"));
                loaiSanPham.setTenLoaiSanPham(rs.getString("tenloaisanpham"));
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
        return loaiSanPham;
    }
 private static final String URL = "jdbc:sqlserver://HUNGGA\\HUNGGA:1433;databaseName=DoAn_CNJava;databaseName=DoAn_CNJava;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";


    public List<dto_LoaiSanPham> getAll() {
        List<dto_LoaiSanPham> DSLoaiSanPham = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM loaisanpham")) {
            while (resultSet.next()) {
                String maLoai = resultSet.getString("maloaisanpham");
                String tenLoai = resultSet.getString("tenloaisanpham");

                DSLoaiSanPham.add(new dto_LoaiSanPham(maLoai, tenLoai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DSLoaiSanPham;
    }

    public void add(dto_LoaiSanPham loaiSanPhamDTO) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("INSERT INTO loaisanpham (maloaisanpham, tenloaisanpham) VALUES (?, ?)");) {
            statement.setString(1, loaiSanPhamDTO.getMaLoaiSanPham());
            statement.setNString(2, loaiSanPhamDTO.getTenLoaiSanPham());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(dto_LoaiSanPham loaiSanPhamDTO) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("UPDATE loaisanpham SET tenloaisanpham = ? WHERE maloaisanpham = ?")) {
            statement.setString(1, loaiSanPhamDTO.getTenLoaiSanPham());
            statement.setNString(2, loaiSanPhamDTO.getMaLoaiSanPham());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String maloai) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("DELETE FROM loaisanpham WHERE maloaisanpham = ?")) {
            statement.setString(1, maloai);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public boolean kiemTraMaLoai(String maThuongHieu) {
    boolean isDuplicate = false;
    String sql = "SELECT COUNT(*) FROM loaisanpham WHERE maloaisanpham = ?";
    
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement statement = connection.prepareStatement(sql)) {
        
        statement.setString(1, maThuongHieu);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            isDuplicate = count > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return isDuplicate;
    }

}
