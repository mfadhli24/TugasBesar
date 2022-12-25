/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;


/**
 *
 * @author FDL
 */
public class MySqlConnection {
    private final static String DB_URL = "jdbc:mysql://localhost/kasir";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";
    
    private static MySqlConnection instance;
    
    public static MySqlConnection getInstance(){
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance;
    }
    
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Koneksi ke database berhasil;");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Koneksi ke database gagal " +e.getMessage());
        }
        return connection;
    }
    
}
