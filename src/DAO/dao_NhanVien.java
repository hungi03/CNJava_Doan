/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.dto_NhanVien;
import GUI.Login;
import GUI.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Tran Viet Phuc
 */
public class dao_NhanVien {

    public static ArrayList<dto_NhanVien> getListNhanVien() {
        ArrayList<dto_NhanVien> ds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM nhanvien";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);

            while (rs.next()) {
                dto_NhanVien clth = new dto_NhanVien();
                clth.setMaNhanVien(rs.getString("manhanvien"));
                clth.setHoTen(rs.getString("hoten"));
                ds.add(clth);
            }
            helper.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ds;
    }
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
    public dto_NhanVien dangNhap(String maNhanVien, String matKhau) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://HUNGGA\\HUNGGA:1433;databaseName=DoAn_CNJava;user=sa;password=123;encrypt=true;trustServerCertificate=true";

        try {
            Class.forName(driver); // Load the SQL Server JDBC driver

            // Establish the database connection
            conn = DriverManager.getConnection(url);

            // Use the connection only if established successfully
            if (conn != null) {
                String sql = "SELECT * FROM nhanvien WHERE manhanvien = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, maNhanVien);
                //pstmt.setString(2, matKhau);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    String passHashed = rs.getString("matkhau");
                    if (checkPassword(matKhau, passHashed)) {
                        // Login successful
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                        Main frm = new Main();
                        frm.setVisible(true);
                        Login f = new Login();
                        f.setVisible(false);
                    } else {
                        // Login failed
                        JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!");
                    }
                    
                } else {
                    // Login failed
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!");
                }
            } else {
                // Connection failed, inform the user
                JOptionPane.showMessageDialog(null, "Không thể kết nối đến database!");
            }
        } catch (ClassNotFoundException e) {
            // Handle case where the SQL Server JDBC driver is not found
            JOptionPane.showMessageDialog(null, "Không tìm thấy driver JDBC cho SQL Server!");
            e.printStackTrace(); // Optional: Print stack trace for debugging
        } catch (SQLException e) {
            // Handle general SQL exceptions (e.g., connection errors, syntax errors)
            JOptionPane.showMessageDialog(null, "Lỗi kết nối database: " + e.getMessage());
            e.printStackTrace(); // Optional: Print stack trace for debugging
        } finally {
            // Close resources in reverse order of creation (important for resource management)
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Optional: Print stack trace for debugging
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Optional: Print stack trace for debugging
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Optional: Print stack trace for debugging
                }
            }
        }

        return null; // Trả về null nếu đăng nhập không thành công
    }

    public void themNhanVien(dto_NhanVien nhanVien) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO nhanvien (manhanvien, hoten, gioitinh, sodienthoai, email, matkhau, phanquyen) VALUES (?, ?, ?, ?, ?, ?, ?)";
            JDBC_Connect helper = new JDBC_Connect();
            helper.open();
            conn = helper.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nhanVien.getMaNhanVien());
            pstmt.setString(2, nhanVien.getHoTen());
            pstmt.setString(3, nhanVien.getGioiTinh());
            pstmt.setString(4, nhanVien.getSoDienThoai());
            pstmt.setString(5, nhanVien.getEmail());
            pstmt.setString(6, nhanVien.getMatKhau());
            pstmt.setString(7, nhanVien.getPhanQuyen());

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
    
}
