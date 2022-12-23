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
import javax.swing.JOptionPane;
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
        this.barangDao = barangDao;
        this.kategoriDao = kategoriDao;
        
        this.kategoriList = kategoriDao.findAll();
        this.barangList = barangDao.findAll();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Barang");

        
        JLabel lblNama = new JLabel("Nama Barang: ");
       lblNama.setBounds(15, 40, 350, 20);
       
       textFieldNama = new JTextField();
       textFieldNama.setBounds(15, 60, 350, 30);
       
       JLabel lblNoHP = new JLabel("Harga : ");
       lblNoHP.setBounds(15, 100, 350, 20);
       
       textFieldHarga = new JTextField();
       textFieldHarga.setBounds(15, 120, 350, 30);
       
       JLabel lblKategori = new JLabel("Kategori: ");
       lblKategori.setBounds(15, 160, 350, 20);
       
       comboKategori = new JComboBox();
       comboKategori.setBounds(15, 190, 350, 30);
       
       JButton button = new JButton("Simpan");
       button.setBounds(15,250,350,40);
       
       javax.swing.JTable table = new JTable();
       JScrollPane scrollableTable = new JScrollPane(table);
       scrollableTable.setBounds(15, 300, 350, 130);
       
       tableModel= new BarangTableModel(barangList);
       table.setModel(tableModel);
       populateComboKategori();
       
       BarangButtonSimpanActionListener actionListener = new BarangButtonSimpanActionListener(this,barangDao);
       button.addActionListener(actionListener);
       
       this.add(button);
       this.add(textFieldNama);
       this.add(textFieldHarga);
       this.add(lblNama);
       this.add(lblNoHP);
       this.add(lblKategori);
       this.add(comboKategori);
       this.add(scrollableTable);
        
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    public void populateComboKategori(){
    this.kategoriList = this.kategoriDao.findAll();
    comboKategori.removeAllItems();

    for(Kategori kategori: this.kategoriList){
        comboKategori.addItem(kategori.getNamaKategori());
        
    }
    }
    
    public String getNama(){
       return textFieldNama.getText();
   }
    
    public String getHarga(){
       return textFieldHarga.getText();
   }
    
    public Kategori getKategori(){
        return kategoriList.get(comboKategori.getSelectedIndex());
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
   
   public void showAlert(String message){
       JOptionPane.showMessageDialog(this, message);
   }
   
}
