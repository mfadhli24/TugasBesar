/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.barang;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import src.dao.*;
import src.model.Barang;
import src.model.Kategori;

/**
 *
 * @author FDL
 */
public class BarangFrame extends JFrame{
   private List<Kategori>  kategoriList;
   private List<Barang>  barangList;
   private JTextField textFieldNama, textFieldHarga;
   private BarangTableModel tableModel;
   private JComboBox comboKategori;
   private BarangDao barangDao;
   private KategoriDao kategoriDao;

    public BarangFrame(BarangDao barangDao, KategoriDao kategoriDao) {
        this.kategoriList = kategoriDao.findAll();
        this.barangList = barangDao.findAll();
        
        this.barangDao = barangDao;
        this.kategoriDao = kategoriDao;
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel lblNama = new JLabel("Nama Barang: ");
       lblNama.setBounds(15, 40, 350, 10);
       
       textFieldNama = new JTextField();
       textFieldNama.setBounds(15, 60, 350, 30);
       
       JLabel lblNoHP = new JLabel("No Harga : ");
       lblNoHP.setBounds(15, 100, 350, 10);
       
       textFieldHarga = new JTextField();
       textFieldHarga.setBounds(15, 120, 350, 30);
       
       JLabel lblJenisKelamin = new JLabel("Jenis Kemalin : ");
       lblJenisKelamin.setBounds(15, 200, 350, 10);
       
       comboKategori = new JComboBox();
       comboKategori.setBounds(15, 220, 350, 30);
       comboKategori.addItem(kategoriList);
       
       JButton button = new JButton("Simpan");
       button.setBounds(15,250,350,40);
       
       javax.swing.JTable table = new JTable();
       JScrollPane scrollableTable = new JScrollPane(table);
       scrollableTable.setBounds(15, 280, 350, 130);
       
       tableModel= new BarangTableModel(barangList);
       table.setModel(tableModel);
       
       BarangButtonSimpanActionListener actionListener = new BarangButtonSimpanActionListener(this,barangDao);
       button.addActionListener(actionListener);
       
       this.add(button);
       this.add(textFieldNama);
       this.add(textFieldHarga);
       this.add(lblNama);
       this.add(lblNoHP);
       this.add(lblJenisKelamin);
       this.add(scrollableTable);
        
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    public String getNama(){
       return textFieldNama.getText();
   }
    
    public String getHarga(){
       return textFieldNama.getText();
   }
    
//    public int getRow(){
//        return row;
//    }
//    
//    public int getCol(){
//        return col;
//    }
   
   public void addBarang(Barang barang){
       tableModel.add(barang);
       textFieldNama.setText("");
       textFieldHarga.setText("");
   }
   
}
