/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import src.db.MySqlConnection;
import src.model.Barang;
import src.model.Kategori;

/**
 *
 * @author FDL
 */
public class BarangDao {
  public int insert(Barang barang){
        int result = -1;
        try (Connection conn = MySqlConnection.getInstance().getConnection()){
            PreparedStatement state = conn.prepareStatement("insert into barang (id_barang, id_kategori, nama_barang, harga) "
                    + "values(?, ?, ?, ?)");
            state.setString(1, barang.getId());
            state.setString(2, barang.getKategori().getId());
            state.setString(3, barang.getNama());
            state.setString(4, barang.getHarga());
            
            
////            state.setString(1, "2");
//            state.setString(2, "1a483f92-f294-4c7e-be9f-16b5a5fb1fc7");
//            state.setString(3, "3");
//            state.setString(4, "4");
            
            result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int update(Barang barang){
        int result = -1;
        try (Connection conn = MySqlConnection.getInstance().getConnection()){
//            PreparedStatement state = conn.prepareStatement("update barang set nama_barang = ?, id_kategori = ?, harga = ? where id_barang = ?");
            PreparedStatement state = conn.prepareStatement("update barang set nama_barang = ?, harga = ? where id_barang = ?");
            state.setString(1, barang.getNama());
            state.setString(2, barang.getHarga());
//            state.setString(3, barang.getKategori().getNamaKategori());
            
            state.setString(3, barang.getId());
            result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int delete(Barang barang){
        int result = -1;
        try (Connection conn = MySqlConnection.getInstance().getConnection()){
            PreparedStatement state = conn.prepareStatement("delete from kategori where id_kategori = ?");
            state.setString(1, barang.getId());
            result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Barang> findAll(){
        List<Barang> list = new ArrayList<>();
        try (Connection conn = MySqlConnection.getInstance().getConnection(); 
                Statement state = conn.createStatement();){
            try (ResultSet resultSet = state.executeQuery("select * from barang, kategori where barang.id_kategori = kategori.id_kategori ");){
//            try (ResultSet resultSet = state.executeQuery("select barang.id_barang, barang.nama_barang, "
//                    + "barang.id_kategori, kategori.id_kategori, kategori.nama_kategori, barang.harga from barang join kategori on kategori.id_kategori = barang.id_barang");){
              while(resultSet.next())  {
                  Barang barang = new Barang();
                  barang.setId(resultSet.getString("id_barang"));
                  barang.setNama(resultSet.getString("nama_barang"));
                  barang.setHarga(resultSet.getString("harga"));
                  
                  Kategori kategori = new Kategori();
                  kategori.setId(resultSet.getString("id_kategori"));
                  kategori.setNamaKategori(resultSet.getString("nama_kategori"));
                  
                  barang.setKategori(kategori);
                  list.add(barang);
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
