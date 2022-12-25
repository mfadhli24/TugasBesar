/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.main;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import src.dao.BarangDao;
import src.dao.TransaksiDao;
import src.model.Transaksi;

/**
 *
 * @author FDL
 */
public class MainTableModel extends AbstractTableModel{
    private String[] columnNames = {"Nama Pembeli", "Nama Barang", "Qyt", "Total"};
//    private ArrayList<Member> data = new ArrayList<Member>();
    private List<Transaksi> data;

    public MainTableModel(List<Transaksi> data) {
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
       Transaksi rowItem= data.get(row);
       String value = "";
       
       switch (col)
       {
           case 0:
               value = rowItem.getNama();
               break;
           case 1:
               value = rowItem.getBarang().getNama();
               break;
           case 2:
               value = rowItem.getQyt();
               break;
           case 3:
               value = rowItem.getTotal();
               break;
        }
       
       return value;
   }
   
    @Override
      public void setValueAt(Object aValue, int row, int col){
       Transaksi rowItem = data.get(row);
       
       switch (col)
       {
           case 0:
               rowItem.setNama((String) aValue);
               break;
//           case 1:
//               rowItem.se((String) aValue);
//               break;
//           case 2:
////               rowItem.setId_kategori((Kategori) aValue);
//               break;
           
        }
        TransaksiDao dao = new TransaksiDao();
        dao.update(rowItem);
   }
   
   public boolean isCellEditable(int row, int col){
        return true;
    }
   
   public void add(Transaksi value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
