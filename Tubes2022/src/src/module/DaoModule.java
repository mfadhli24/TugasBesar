/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.module;

import src.dao.*;

/**
 *
 * @author FDL
 */
public class DaoModule {
    private final KategoriDao kategoriDao;
    private final BarangDao barangDao;

    public DaoModule() {
        this.kategoriDao = new KategoriDao();
        this.barangDao = new BarangDao();
    }

    public KategoriDao getKategoriDao() {
        return kategoriDao;
    }

    public BarangDao getBarangDao() {
        return barangDao;
    }
    
    
    
    
}
