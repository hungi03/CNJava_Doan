/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tran Viet Phuc
 */
public class JDBC_Connect {

    private Connection connection;

    public void open() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://HUNGGA\\HUNGGA:1433;databaseName=DoAn_CNJava;user=sa;password=123;encrypt=true;trustServerCertificate=true";
            connection = DriverManager.getConnection(connectionURL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String sql) {
        int n = -1;
        try {
            Statement sm = connection.createStatement();
            n = sm.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Connection getConnection() {
        return connection;
    }
}
