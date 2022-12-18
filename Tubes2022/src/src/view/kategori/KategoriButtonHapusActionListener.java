///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package src.view.kategori;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.UUID;
//import javax.swing.JOptionPane;
//import src.dao.KategoriDao;
//import src.model.Kategori;
//
///**
// *
// * @author FDL
// */
//public class KategoriButtonHapusActionListener implements ActionListener{
//    private KategoriFrame kategoriFrame;
//    private KategoriDao kategoriDao;
//    private int row;
//
//    public KategoriButtonHapusActionListener(KategoriFrame kategoriFrame, KategoriDao kategoriDao) {
//        this.kategoriFrame = kategoriFrame;
//        this.kategoriDao = kategoriDao;
//    }
//    
//    @Override
//        public void actionPerformed(ActionEvent e) {
//            
//            int kategori = this.kategoriFrame.getCol();
//            Kategori kate = new Kategori();
//            kate.getId();
//            kate.getNamaKategori();
//
////            this.kategoriFrame.addKategori(kate);
//            this.kategoriDao.delete(kate);
//            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
//        }
//    
//}
