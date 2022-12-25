package src.view.kategori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;
import src.model.Kategori;
import src.module.DaoModule;

public class KategoriController {
    private final DaoModule daoModule;
    private final KategoriFrame kategoriFrame;

    public KategoriController(DaoModule daoModule) {
        this.daoModule = daoModule;
        kategoriFrame = new KategoriFrame(null);

        kategoriFrame.addButtonSimpanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpan();
            }
        });
    }

    public void showKategoriFrame() {
        List<Kategori> jenisMemberList = daoModule.getKategoriDao().findAll();
        kategoriFrame.populateTable(jenisMemberList);
        kategoriFrame.setVisible(true);
    }

    public void simpan() {
        String nama = this.kategoriFrame.getKategori();
        Kategori kategori = new Kategori();
        kategori.setId(UUID.randomUUID().toString());
        kategori.setNama(nama);
        this.kategoriFrame.addKategori(kategori);
        daoModule.getKategoriDao().insert(kategori);
    }
}
