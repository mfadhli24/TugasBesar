/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.main;

import src.module.DaoModule;
import src.view.kategori.KategoriController;
import src.view.barang.BarangController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author FDL
 */
public class MainController {

    private final MainFrame mainFrame;
    private final BarangController barangController;
    private final KategoriController kategoriController;

    public MainController() {
        mainFrame = new MainFrame();
        DaoModule daoModule = new DaoModule();

        barangController = new BarangController(daoModule);
        kategoriController = new KategoriController(daoModule);

        mainFrame.addButtonKategoriActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showKategoriFrame();
            }
        });
        mainFrame.addButtonBarangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBarangFrame();
            }
        });
    }

    public void showMainFrame() {
        this.mainFrame.setVisible(true);
    }

    public void showKategoriFrame() {
        kategoriController.showKategoriFrame();
    }

    public void showBarangFrame() {
        barangController.showBarangFrame();
    }

}
