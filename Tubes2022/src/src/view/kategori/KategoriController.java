/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.kategori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import src.model.Kategori;
import src.module.DaoModule;
import src.view.barang.BarangController;
import src.view.barang.BarangPdfExport;

/**
 *
 * @author FDL
 */
public class KategoriController {

    private final DaoModule daoModule;
    private final KategoriFrame kategoriFrame;
    private final KategoriPdfExport kategoriPdfExport;

    public KategoriController(DaoModule daoModule) {
        this.daoModule = daoModule;
        kategoriFrame = new KategoriFrame();
        this.kategoriPdfExport = new KategoriPdfExport();
        
        this.kategoriFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpan();
            }
        });
        
        this.kategoriFrame.addButtonExportPdfActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KategoriController.this.exportPdf();
            }
        });
    }

    public void showKategoriFrame() {
        List<Kategori> kategoriList = daoModule.getKategoriDao().findAll();
        kategoriFrame.populateTable(kategoriList);
        kategoriFrame.setVisible(true);
    }

    public void simpan() {
        String kategori = this.kategoriFrame.getKategori();
        if (kategori.isEmpty()) {
            this.kategoriFrame.showAlert("Nama kategori tidak boleh kosong");
        } else {
            Kategori kate = new Kategori();
            kate.setId(UUID.randomUUID().toString());
            kate.setNamaKategori(kategori);

            this.kategoriFrame.addKategori(kate);
            daoModule.getKategoriDao().insert(kate);

        }

    }
    
    public void exportPdf() {
        try {
            kategoriPdfExport.export(kategoriFrame.getKategoriList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
