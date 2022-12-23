/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.kategori;

import java.util.ArrayList;
import javax.swing.table.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import src.dao.KategoriDao;
import src.model.Kategori;

/**
 *
 * @author FDL
 */
public class KategoriTableModel extends AbstractTableModel{
    private String[] columnNames = {"Kategori Barang"};
//    private ArrayList<Member> data = new ArrayList<Member>();
    private List<Kategori> data;

    public KategoriTableModel(List<Kategori> data) {
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
       Kategori rowItem= data.get(row);
       String value = "";
       
       switch (col)
       {
           case 0:
               value = rowItem.getNamaKategori();
               break;
        }
       
       return value;
   }
   
    @Override
      public void setValueAt(Object aValue, int row, int col){
       Kategori rowItem = data.get(row);
       
       switch (col)
       {
           case 0:
               rowItem.getId();
               rowItem.setNamaKategori((String) aValue);
               break;
           
        }
        KategoriDao dao = new KategoriDao();
        dao.update(rowItem);
   }
   
   public boolean isCellEditable(int row, int col){
        return true;
    }
   
   public void add(Kategori value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
