package src.module;

import src.dao.BarangDao;
import src.dao.KategoriDao;

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

    public BarangDao getbaraBarangDao() {
        return barangDao;
    }
}
