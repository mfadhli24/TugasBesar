/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.barang;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.*;
import src.dao.BarangDao;
//import src.dao.KategoriDao;
import javax.swing.table.AbstractTableModel;
import src.model.*;

/**
 *
 * @author FDL
 */
public class BarangTableModel extends AbstractTableModel{
    private String[] columnNames = {"Nama Barang", "Harga", "Kategori"};
//    private ArrayList<Member> data = new ArrayList<Member>();
    private List<Barang> data;

    public BarangTableModel(List<Barang> data) {
        this.data = data;
    }
    
    public int getColumnCount(){
       return columnNames.length;
   }
   
   public int getRowCount(){
       return data.size();
   }
   
   public String getColumnName(int col){
       return columnNames[col];
   }
   
   public Object getValueAt(int row, int col){
       Barang rowItem= data.get(row);
       String value = "";
       
       switch (col)
       {
           case 0:
               value = rowItem.getNama();
               break;
           case 1:
               value = rowItem.getHarga();
               break;
           case 2:
               value = rowItem.getKategori().getNamaKategori();
               break;
        }
       
       return value;
   }
   
    @Override
      public void setValueAt(Object aValue, int row, int col){
       Barang rowItem = data.get(row);
       
       switch (col)
       {
           case 0:
               rowItem.setNama((String) aValue);
               break;
           case 1:
               rowItem.setHarga((String) aValue);
               break;
//           case 2:
////               rowItem.setId_kategori((Kategori) aValue);
//               break;
           
        }
        BarangDao dao = new BarangDao();
        dao.update(rowItem);
   }
   
   public boolean isCellEditable(int row, int col){
        return true;
    }
   
   public void add(Barang value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
