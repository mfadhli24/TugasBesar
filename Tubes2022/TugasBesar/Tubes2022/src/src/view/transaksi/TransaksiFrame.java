/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.transaksi;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import src.dao.*;
import src.model.*;
import src.dao.*;
/**
 *
 * @author FDL
 */
public class TransaksiFrame extends JFrame{
    
    public TransaksiFrame (TransaksiDao transaksiDao, KategoriDao kategoriDao){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,500);
        this.setLayout(null);
        
        
    }
}
