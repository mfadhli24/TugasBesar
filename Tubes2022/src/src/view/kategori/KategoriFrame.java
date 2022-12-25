/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.kategori;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import src.dao.KategoriDao;
import src.model.Kategori;

/**
 *
 * @author FDL
 */
public class KategoriFrame extends JFrame {

    private List<Kategori> kategoriList;
    private JTextField textFieldKategori;
    private final JTable table;
    private final JButton btnSimpan;
    private final JButton btnExportPdf;

    private KategoriTableModel tableModel;
    private KategoriDao kategoriDao;
//    private int row, col;

    public KategoriFrame() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Kategori");

        JLabel lblKategori = new JLabel("Kategori Barang: ");
        lblKategori.setBounds(15, 20, 350, 20);

        textFieldKategori = new JTextField();
        textFieldKategori.setBounds(15, 40, 350, 30);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(15, 80, 150, 40);

        btnExportPdf = new JButton("Export PDF");
        btnExportPdf.setBounds(210, 80, 150, 40);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 150, 350, 200);

        this.add(btnSimpan);
        this.add(btnExportPdf);
        this.add(textFieldKategori);
        this.add(lblKategori);
        this.add(scrollableTable);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public String getKategori() {
        return textFieldKategori.getText();
    }

    public void addKategori(Kategori kategori) {
        tableModel.add(kategori);
        textFieldKategori.setText("");
    }

    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void addButtonSimpanActionListener(ActionListener actionListener) {
        btnSimpan.addActionListener(actionListener);
    }

    public void addButtonExportPdfActionListener(ActionListener actionListener) {
        btnExportPdf.addActionListener(actionListener);
    }

    public void populateTable(List<Kategori> kategoriList) {
        this.kategoriList = kategoriList;
        tableModel = new KategoriTableModel(kategoriList);
        table.setModel(tableModel);
    }

    public List<Kategori> getKategoriList() {
        return kategoriList;
    }

}
