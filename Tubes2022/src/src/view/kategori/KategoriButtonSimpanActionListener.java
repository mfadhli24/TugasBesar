/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.kategori;
import java.util.UUID;
import java.awt.event.*;
import src.model.Kategori;
import src.dao.KategoriDao;
/**
 *
 * @author FDL
 */
public class KategoriButtonSimpanActionListener implements ActionListener{
    private KategoriFrame kategoriFrame;
    private KategoriDao kategoriDao;

    public KategoriButtonSimpanActionListener(KategoriFrame kategoriFrame, KategoriDao kategoriDao) {
        this.kategoriFrame = kategoriFrame;
        this.kategoriDao = kategoriDao;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String kategori = this.kategoriFrame.getKategori();
        Kategori kate = new Kategori();
        kate.setId(UUID.randomUUID().toString());
        kate.setNamaKategori(kategori);
        
        this.kategoriFrame.addKategori(kate);
        this.kategoriDao.insert(kate);
    }
}
