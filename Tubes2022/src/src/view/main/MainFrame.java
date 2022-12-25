/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
//import src.dao.JenisKelaminDao;
import src.model.*;
import src.view.barang.*;
import src.view.kategori.*;
import src.dao.*;

/**
 *
 * @author FDL
 */
public class MainFrame extends JFrame {

    private List<Kategori> ketegoriList;
    private List<Barang> barangList;
    private JTextField textFieldNama, textFieldQyt;
//   private BarangTableModel tableModel;
    private JComboBox comboBarang;
//   private JTextArea txtAlamat;
    private final JButton buttonBarang;
    private final JButton buttonKategori;
    private final JButton buttonTransaksi;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Kasir Qu");

        buttonKategori = new JButton("Tambah Kategori");
        buttonKategori.setBounds(15, 30, 150, 40);
        buttonBarang = new JButton("Tambah Barang");
        buttonBarang.setBounds(210, 30, 150, 40);

        JLabel lblNama = new JLabel("Nama Pembeli :");
        lblNama.setBounds(15, 80, 350, 40);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 120, 350, 30);

        JLabel lblBarang = new JLabel("Pilih Barang : ");
        lblBarang.setBounds(15, 160, 350, 30);

        comboBarang = new JComboBox();
        comboBarang.setBounds(15, 200, 150, 30);

        JLabel lblQyt = new JLabel("Qyt : ");
        lblQyt.setBounds(180, 200, 150, 30);

        textFieldQyt = new JTextField();
        textFieldQyt.setBounds(210, 200, 80, 30);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 300, 355, 150);
        
        buttonTransaksi = new JButton("Transaksi");
        buttonTransaksi.setBounds(120, 250, 150, 40);

        this.add(buttonKategori);
        this.add(buttonBarang);
        this.add(buttonTransaksi);
        this.add(lblNama);
        this.add(lblQyt);
        this.add(lblBarang);
        this.add(comboBarang);
        this.add(textFieldNama);
        this.add(textFieldQyt);
        this.add(scrollableTable);
        this.setSize(400, 500);
        this.setLayout(null);

    }

    public JButton getButtonBarang() {
        return buttonBarang;
    }

    public JButton getButtonKategori() {
        return buttonKategori;
    }

    public void addButtonKategoriActionListener(ActionListener actionListener) {
        buttonKategori.addActionListener(actionListener);
    }

    public void addButtonBarangActionListener(ActionListener actionListener) {
        buttonBarang.addActionListener(actionListener);
    }
}
