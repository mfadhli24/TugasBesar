/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.barang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import src.dao.BarangDao;
import src.dao.KategoriDao;
import src.model.Barang;
import src.model.Kategori;
import src.view.kategori.KategoriFrame;

/**
 *
 * @author FDL
 */
public class BarangButtonSimpanActionListener implements ActionListener{
    private BarangFrame barangFrame;
    private BarangDao barangDao;

    public BarangButtonSimpanActionListener(BarangFrame barangFrame, BarangDao barangDao) {
        this.barangFrame = barangFrame;
        this.barangDao = barangDao;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.barangFrame.getNama();
        String harga = this.barangFrame.getHarga();
        Barang bar = new Barang();
        bar.setId(UUID.randomUUID().toString());
        bar.setNama(nama);
        bar.setHarga(harga);
//        bar.setKategori(barang);
        
        this.barangFrame.addBarang(bar);
        this.barangDao.insert(bar);
    }
}
