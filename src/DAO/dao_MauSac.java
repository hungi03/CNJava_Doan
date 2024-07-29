/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.dto_MauSac;
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
public class dao_MauSac {

    public static ArrayList<dto_MauSac> getListMauSac() {
        ArrayList<dto_MauSac> ds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mausac";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);

            while (rs.next()) {
                dto_MauSac clms = new dto_MauSac();
                clms.setMaMauSac(rs.getString("mamausac"));
                clms.setTenMauSac(rs.getString("tenmausac"));
                ds.add(clms);
            }
            helper.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
    }
    
    public dto_MauSac getMauSacById(String maMauSac) {
        dto_MauSac mauSac = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM mausac WHERE mamausac = ?";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            conn = helper.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maMauSac);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                mauSac = new dto_MauSac();
                mauSac.setMaMauSac(rs.getString("mamausac"));
                mauSac.setTenMauSac(rs.getString("tenmausac"));
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
        return mauSac;
    }
 private static final String URL = "jdbc:sqlserver://HUNGGA\\HUNGGA:1433;databaseName=DoAn_CNJava;databaseName=DoAn_CNJava;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    
    public List<dto_MauSac> getAll() {
        List<dto_MauSac> DSMauSac = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM mausac")) {
            while (resultSet.next()) {
                String maMauSac = resultSet.getString("maMauSac");
                String tenMauSac = resultSet.getString("tenMauSac");
   
                DSMauSac.add(new dto_MauSac(maMauSac, tenMauSac));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DSMauSac;
    }
     public void add(dto_MauSac mauSacDTO) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO mausac (mamausac, tenmausac) VALUES (?, ?)");) {
            statement.setString(1, mauSacDTO.getMaMauSac());
            statement.setNString(2, mauSacDTO.getTenMauSac());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(dto_MauSac mauSacDTO) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("UPDATE mausac SET tenmausac = ? WHERE mamausac = ?")) {         
            statement.setString(1, mauSacDTO.getTenMauSac());
            statement.setNString(2, mauSacDTO.getMaMauSac());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String maMauSac) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM mausac WHERE mamausac = ?")) {
            statement.setString(1, maMauSac);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  public boolean kiemTraMaMauSac(String maMau) {
    boolean isDuplicate = false;
    String sql = "SELECT COUNT(*) FROM mausac WHERE mamausac = ?";
    
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement statement = connection.prepareStatement(sql)) {
        
        statement.setString(1, maMau);
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
