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
            PreparedStatement state = conn.prepareStatement("insert into kategori (id_barang, id_kategori, nama_barang, harga) "
                    + "values(?, ?, ?. ?)");
            state.setString(1, barang.getId());
            state.setString(2, barang.getNama());
            state.setString(3, barang.getKategori().getNamaKategori());
            state.setString(4, barang.getHarga());
            result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int update(Barang barang){
        int result = -1;
        try (Connection conn = MySqlConnection.getInstance().getConnection()){
            PreparedStatement state = conn.prepareStatement("update barang set nama_barang = ?, id_kategori = ?, harga = ? where id_barang = ?");
            state.setString(1, barang.getHarga());
            state.setString(2, barang.getKategori().getNamaKategori());
            state.setString(3, barang.getNama());
            state.setString(4, barang.getId());
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
            try (ResultSet resultSet = state.executeQuery("select barang.id_barang, barang.nama_barang "
                    + "kategori.id_kategori id_kategori, kategori.nama_kategori, barang.harga from barang join kategori on kategori.id_kategori = barang.id_barang");){
              while(resultSet.next())  {
                  Barang barang = new Barang();
                  barang.setId(resultSet.getString("id_kategori"));
                  barang.setNama(resultSet.getString("nama_barang"));
                  
                  Kategori kategori = new Kategori();
                  kategori.setId(resultSet.getString("id_kategori"));
                  kategori.setNamaKategori(resultSet.getString("nama_kategori"));
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
