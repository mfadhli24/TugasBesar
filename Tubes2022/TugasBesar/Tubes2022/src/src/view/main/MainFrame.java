/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.view.main;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
//import src.dao.JenisKelaminDao;
import src.model.*;
import src.view.barang.*;
import src.view.kategori.*;
import src.dao.*;


/**
 *
 * @author FDL
 */
public class MainFrame extends javax.swing.JFrame {
   private List<Kategori>  ketegoriList;
   private List<Barang>  barangList;
   private JTextField textFieldNama, textFieldQyt;
//   private BarangTableModel tableModel;
   private JComboBox comboBarang;
//   private JTextArea txtAlamat;
   private JButton buttonBarang;
   private JButton buttonKategori;
   private JPanel panel1, panel2, panel3, panel4;
   
   private KategoriDao kategoriDao;
   private BarangDao barangDao;
   private BarangFrame barangFrame;
   private KategoriFrame kategoriFrame;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.kategoriDao = new KategoriDao();
        this.barangDao = new BarangDao();
        
        
        this.setTitle("Kasir Qu");
        
        this.kategoriFrame = new KategoriFrame(kategoriDao);
        this.barangFrame = new BarangFrame(barangDao, kategoriDao);

        
        JLabel lblNama = new JLabel("Nama Pembeli :");
        JLabel lblBarang = new JLabel("Pilih Barang : ");
        JLabel lblQyt = new JLabel("Jumlah : ");
        
        
        textFieldNama = new JTextField(15);
        textFieldQyt = new JTextField(15);    

        
        MainButtonLoginActionListener actionListener = new MainButtonLoginActionListener(this);

        this.buttonKategori = new JButton("Tambah Kategori");
        this.buttonBarang = new JButton("Tambah Barang");
        
        this.buttonBarang.addActionListener(actionListener);
        this.buttonKategori.addActionListener(actionListener);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 180, 10, 30);
        
//        tableModel= new BarangTableModel(barangList);
//        table.setModel(tableModel);


        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel1.add(buttonKategori);
        panel1.add(buttonBarang);
        

//        panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(3, 1));
//        panel2.add(lblNama);
//        panel2.add(lblBarang);
//        panel2.add(lblQyt);
//        
//        panel3 = new JPanel();
//        panel3.setLayout(new GridLayout(3, 1));
//        panel3.add(textFieldNama);
//        panel3.add(textFieldQyt);
        
//        panel4 = new JPanel();
//        panel4.setLayout(new GridLayout(1, 1));
//        panel4.add(scrollableTable);


        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel1,BorderLayout.PAGE_START);
//        container.add(panel2, BorderLayout.LINE_START);
//        container.add(panel3, BorderLayout.LINE_END);
//        container.add(panel4, BorderLayout.SOUTH);
    }
    
//    public String getUsername(){
//       return txtUsername.getText();
//    }
//    
//    public String getPassword(){
//       return txtPassword.getPassword().toString();
//    }
    
    public JButton getButtonBarang(){
        return buttonBarang;
    }
    
    public JButton getButtonKategori(){
        return buttonKategori;
    }
    
    public void showBarangFrame(){
        if(barangFrame == null) {
          barangFrame = new BarangFrame(barangDao, kategoriDao) ;
        } 
        barangFrame.setVisible(true);
    }
    
    public void showKategoriFrame(){
        if(kategoriFrame == null) {
          kategoriFrame = new KategoriFrame(kategoriDao) ;
        } 
        kategoriFrame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new MainFrame().setVisible(true);
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
