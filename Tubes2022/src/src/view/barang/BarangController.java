/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.barang;

import src.model.*;
import src.module.DaoModule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author FDL
 */
public class BarangController {

    private final DaoModule daoModule;
    private final BarangFrame barangFrame;
    private final BarangPdfExport barangPdfExport;

    public BarangController(DaoModule daoModule) {
        this.daoModule = daoModule;
        this.barangFrame = new BarangFrame();
        this.barangPdfExport = new BarangPdfExport();

        this.barangFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BarangController.this.simpan();
            }
        });
        this.barangFrame.addButtonExportPdfActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BarangController.this.exportPdf();
            }
        });
    }

    public void showBarangFrame() {
        List<Barang> barangList = daoModule.getBarangDao().findAll();
        barangFrame.populateTable(barangList);
        List<Kategori> kategoriList
                = daoModule.getKategoriDao().findAll();
        barangFrame.populateComboKategori(kategoriList);
        barangFrame.setVisible(true);
    }

    public void simpan() {
        String nama = this.barangFrame.getNama();
        String harga = this.barangFrame.getHarga();
        Kategori kategori = this.barangFrame.getKategori();
        
        if (nama.isEmpty()) {
            this.barangFrame.showAlert("Nama barang tidak boleh kosong");
        } else if (harga.isEmpty()){
            this.barangFrame.showAlert("Harga barang tidak boleh kosong");
        } else {
        Barang bar = new Barang();
        bar.setId(UUID.randomUUID().toString());
        bar.setNama(nama);
        bar.setHarga(harga);
        bar.setKategori(kategori);
            
            
            this.barangFrame.addBarang(bar);
            daoModule.getBarangDao().insert(bar);
        }
    }

    public void exportPdf() {
        try {
            barangPdfExport.export(barangFrame.getBarangList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
