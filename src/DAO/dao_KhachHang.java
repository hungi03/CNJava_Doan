/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.dto_KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AI NHI
 */
public class dao_KhachHang {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=DoAn_CNJava;databaseName=DoAn_CNJava;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    public List<dto_KhachHang> getAll() {
        List<dto_KhachHang> DSKhachHang = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM khachhang")) {
            while (resultSet.next()) {
                String maKH = resultSet.getString("makhachhang");
                String tenKH = resultSet.getString("tenkhachhang");
                String soDienThoai = resultSet.getString("sodienthoai");
                String diaChi = resultSet.getString("diachi");

                DSKhachHang.add(new dto_KhachHang(maKH, tenKH, soDienThoai, diaChi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DSKhachHang;
    }
    public void add(dto_KhachHang KH) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO khachhang (makhachhang, tenkhachhang, sodienthoai, diachi) VALUES (?, ?, ?, ?)");) {
            statement.setString(1, KH.getMaKhachHang());
            statement.setNString(2, KH.getTenKhachHang());
            statement.setString(3, KH.getSoDienThoai());
            statement.setNString(4, KH.getDiaChi());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(dto_KhachHang KH) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("UPDATE khachhang SET tenkhachhang = ?, sodienthoai = ?, diachi = ? WHERE makhachhang = ?")) {         
            statement.setString(1, KH.getTenKhachHang());
            statement.setString(2, KH.getSoDienThoai());
            statement.setString(3, KH.getDiaChi());
            statement.setString(4, KH.getMaKhachHang());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String maKH) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM khachhang WHERE makhachhang = ?")) {
            statement.setString(1, maKH);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public dto_KhachHang getOne(String maKH) {
        dto_KhachHang KH = new dto_KhachHang();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM khachhang WHERE makhachhang = ?")) {
            statement.setString(1, maKH);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                KH.setMaKhachHang(resultSet.getString("makhachhang"));
                KH.setTenKhachHang(resultSet.getString("tenkhachhang"));
                KH.setSoDienThoai(resultSet.getString("sodienthoai"));
                KH.setDiaChi(resultSet.getString("diachi"));
            }
      
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return KH;
    }
    public List<dto_KhachHang> search(String search) {
        List<dto_KhachHang> DSKH = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM khachhang " +
                                                                "WHERE LOWER(makhachhang) LIKE ? OR LOWER(tenkhachhang) LIKE ? OR LOWER(sodienthoai) LIKE ? OR LOWER(diachi) LIKE ? ")) {
            
            // Convert search term to lowercase for case-insensitive search
            String searchLower = search.toLowerCase();
            statement.setString(1, "%" + searchLower + "%");
            statement.setString(2, "%" + searchLower + "%");
            statement.setString(3, "%" + searchLower + "%");
            statement.setString(4, "%" + searchLower + "%");
            ResultSet resultSet = statement.executeQuery();          

            while (resultSet.next()) {
                String maKH = resultSet.getString("makhachhang");
                String tenKH = resultSet.getString("tenkhachhang");
                String soDienThoai = resultSet.getString("sodienthoai");
                String diaChi = resultSet.getString("diaChi");
               
                DSKH.add(new dto_KhachHang(maKH, tenKH, soDienThoai, diaChi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DSKH;
    }
}
