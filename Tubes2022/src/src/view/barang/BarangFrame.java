/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.barang;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import src.dao.*;
import src.model.Barang;
import src.model.Kategori;

/**
 *
 * @author FDL
 */
public class BarangFrame extends JFrame {

    private List<Kategori> kategoriList;
    private List<Barang> barangList;
    private final JTextField textFieldNama, textFieldHarga;
    private BarangTableModel tableModel;
    private final JComboBox comboKategori;
    private BarangDao barangDao;
    private KategoriDao kategoriDao;

    private final JButton btnSimpan;
    private final JButton btnExportPdf;
    private final JTable table;

    public BarangFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Barang");

        JLabel lblNama = new JLabel("Nama Barang: ");
        lblNama.setBounds(15, 40, 350, 20);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel lblNoHP = new JLabel("Harga : ");
        lblNoHP.setBounds(15, 100, 350, 20);

        textFieldHarga = new JTextField();
        textFieldHarga.setBounds(15, 120, 350, 30);

        JLabel lblKategori = new JLabel("Kategori: ");
        lblKategori.setBounds(15, 160, 350, 20);

        comboKategori = new JComboBox();
        comboKategori.setBounds(15, 190, 350, 30);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(15, 250, 150, 40);

        btnExportPdf = new JButton("Export PDF");
        btnExportPdf.setBounds(210, 250, 150, 40);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 300, 350, 130);

        tableModel = new BarangTableModel(barangList);
        table.setModel(tableModel);

        this.add(btnSimpan);
        this.add(btnExportPdf);
        this.add(textFieldNama);
        this.add(textFieldHarga);
        this.add(lblNama);
        this.add(lblNoHP);
        this.add(lblKategori);
        this.add(comboKategori);
        this.add(scrollableTable);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public void populateTable(List<Barang> barangList) {
        this.barangList = barangList;
        tableModel = new BarangTableModel(barangList);
        table.setModel(tableModel);
    }

    public void populateComboKategori(List<Kategori> kategoriList) {
        this.kategoriList = kategoriList;
        comboKategori.removeAllItems();

        for (Kategori kategori : kategoriList) {
            comboKategori.addItem(kategori.getNamaKategori());
        }
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public String getHarga() {
        return textFieldHarga.getText();
    }

    public Kategori getKategori() {
        return kategoriList.get(comboKategori.getSelectedIndex());
    }

    public void addBarang(Barang barang) {
        tableModel.add(barang);
        textFieldNama.setText("");
        textFieldHarga.setText("");
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

    public List<Barang> getBarangList() {
        return barangList;
    }

}
