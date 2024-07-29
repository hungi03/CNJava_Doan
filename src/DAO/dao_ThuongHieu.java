/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.dto_ThuongHieu;
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
public class dao_ThuongHieu {

    public static ArrayList<dto_ThuongHieu> getListThuongHieu() {
        ArrayList<dto_ThuongHieu> ds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM thuonghieu";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);

            while (rs.next()) {
                dto_ThuongHieu clth = new dto_ThuongHieu();
                clth.setMaThuongHieu(rs.getString("mathuonghieu"));
                clth.setTenThuongHieu(rs.getString("tenthuonghieu"));
                ds.add(clth);
            }
            helper.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
    }

    public dto_ThuongHieu getThuongHieuById(String maThuongHieu) {
        dto_ThuongHieu thuongHieu = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM thuonghieu WHERE mathuonghieu = ?";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            conn = helper.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maThuongHieu);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                thuongHieu = new dto_ThuongHieu();
                thuongHieu.setMaThuongHieu(rs.getString("mathuonghieu"));
                thuongHieu.setTenThuongHieu(rs.getString("tenthuonghieu"));

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
        return thuongHieu;
    }
 private static final String URL = "jdbc:sqlserver://HUNGGA\\HUNGGA:1433;databaseName=DoAn_CNJava;databaseName=DoAn_CNJava;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";


    public List<dto_ThuongHieu> getAll() {
        List<dto_ThuongHieu> DSThuongHieu = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM thuonghieu")) {
            while (resultSet.next()) {

                String maTH = resultSet.getString("mathuonghieu");
                String tenTH = resultSet.getString("tenthuonghieu");
                DSThuongHieu.add(new dto_ThuongHieu(maTH, tenTH));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DSThuongHieu;
    }

    public void add(dto_ThuongHieu thuongHieu) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("INSERT INTO thuonghieu (mathuonghieu, tenthuonghieu) VALUES (?, ?)");) {
            statement.setString(1, thuongHieu.getMaThuongHieu());
            statement.setNString(2, thuongHieu.getTenThuongHieu());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(dto_ThuongHieu thuongHieu) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("UPDATE thuonghieu SET tenthuonghieu = ? WHERE mathuonghieu = ?")) {
            statement.setString(1, thuongHieu.getTenThuongHieu());
            statement.setNString(2, thuongHieu.getMaThuongHieu());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String maThuongHieu) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("DELETE FROM thuonghieu WHERE mathuonghieu = ?")) {
            statement.setString(1, maThuongHieu);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean kiemTraMaThuongHieu(String maThuongHieu) {
    boolean isDuplicate = false;
    String sql = "SELECT COUNT(*) FROM thuonghieu WHERE mathuonghieu = ?";
    
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
