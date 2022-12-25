/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import src.db.MySqlConnection;
import src.model.Transaksi;

/**
 *
 * @author FDL
 */
public class TransaksiDao {
    public int insert(Transaksi transaksi){
        int result = -1;
        try (Connection conn = MySqlConnection.getInstance().getConnection()){
            PreparedStatement state = conn.prepareStatement("insert into kategori (id_kategori, nama_kategori) values(?, ?)");
//            state.setString(1, transaksi.getId());
//            state.setString(2, transaksi.getNamaKategori());
            result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int update(Transaksi transaksi){
        int result = -1;
        try (Connection conn = MySqlConnection.getInstance().getConnection()){
            PreparedStatement state = conn.prepareStatement("update kategori set nama_kategori = ? where id_kategori = ?");
//            state.setString(1, transaksi.getNamaKategori());
//            state.setString(2, transaksi.getId());
            result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int delete(Transaksi transaksi){
        int result = -1;
        try (Connection conn = MySqlConnection.getInstance().getConnection()){
            PreparedStatement state = conn.prepareStatement("delete from kategori where id_kategori = ?");
            state.setString(1, transaksi.getId());
            result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Transaksi> findAll(){
        List<Transaksi> list = new ArrayList<>();
        try (Connection conn = MySqlConnection.getInstance().getConnection(); 
                Statement state = conn.createStatement();){
            try (ResultSet resultSet = state.executeQuery("select * from kategori");){
              while(resultSet.next())  {
                  Transaksi transaksi = new Transaksi();
//                  transaksi.setId(resultSet.getString("id_kategori"));
//                  transaksi.setNamaKategori(resultSet.getString("nama_kategori"));
                  list.add(transaksi);
              }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
