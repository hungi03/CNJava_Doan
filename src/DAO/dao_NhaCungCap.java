/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.dto_NhaCungCap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VAN_DAO
 */
public class dao_NhaCungCap {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=DoAn_CNJava;databaseName=DoAn_CNJava;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    public List<dto_NhaCungCap> getAll() {
        List<dto_NhaCungCap> DSNhaCungCap = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM nhacungcap")) {
            while (resultSet.next()) {
                String maNCC = resultSet.getString("manhacungcap");
                String tenNCC = resultSet.getString("tennhacungcap");
                String soDienThoai = resultSet.getString("sodienthoai");
                String diaChi = resultSet.getString("diaChi");

                DSNhaCungCap.add(new dto_NhaCungCap(maNCC, tenNCC, soDienThoai, diaChi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DSNhaCungCap;
    }
}
