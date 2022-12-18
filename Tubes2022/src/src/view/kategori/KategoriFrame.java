/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.kategori;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import src.dao.KategoriDao;
import src.model.Kategori;

/**
 *
 * @author FDL
 */
public class KategoriFrame extends JFrame{
    private List<Kategori>  kategoriList;
    private JTextField textFieldKategori;
    private KategoriTableModel tableModel;
    private KategoriDao kategoriDao;
    private int row, col;

    public KategoriFrame(KategoriDao kategoriDao) {
        this.kategoriDao = kategoriDao;
        this.kategoriList = kategoriDao.findAll();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Kategori");
        
        JLabel lblKategori = new JLabel("Kategori Barang: ");
       lblKategori.setBounds(15, 20, 350, 20);
       
       textFieldKategori = new JTextField();
       textFieldKategori.setBounds(15, 40, 350, 30);
       
       JButton btnSimpan = new JButton("Simpan");
       btnSimpan.setBounds(15,80,350,40);
       
       javax.swing.JTable table = new JTable();
       JScrollPane scrollableTable = new JScrollPane(table);
       scrollableTable.setBounds(15, 150, 350, 200);
       
       tableModel= new KategoriTableModel(kategoriList);
       table.setModel(tableModel);
       row = table.getSelectedRow();
       col = table.getSelectedColumn();
       
       JButton btnHapus = new JButton("Hapus");
       btnHapus.setBounds(15,400,350,40);
       
       KategoriButtonSimpanActionListener actionListenerSimpan = new KategoriButtonSimpanActionListener(this,kategoriDao);
       btnSimpan.addActionListener(actionListenerSimpan);
       
//       KategoriButtonHapusActionListener actionListenerHapus = new KategoriButtonHapusActionListener(this, kategoriDao);
//       btnHapus.addActionListener(actionListenerHapus);
       
       this.add(btnSimpan);
       this.add(textFieldKategori);
       this.add(lblKategori);
       this.add(scrollableTable);
//       this.add(btnHapus);
       
       this.setSize(400,500);
       this.setLayout(null);
    }
    
    public String getKategori(){
       return textFieldKategori.getText();
   }
    
//    public int getRow(){
//        return row;
//    }
//    
//    public int getCol(){
//        return col;
//    }
   
   public void addKategori(Kategori kategori){
       tableModel.add(kategori);
       textFieldKategori.setText("");
   }
    
}
