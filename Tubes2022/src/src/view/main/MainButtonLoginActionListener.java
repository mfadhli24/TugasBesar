/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.model.*;

/**
 *
 * @author FDL
 */
public class MainButtonLoginActionListener implements ActionListener {
    private MainFrame mainFrame;

    public MainButtonLoginActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
//        this.loginDao = loginDao;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainFrame.getButtonBarang()) {
            mainFrame.showBarangFrame();
        } else {
            mainFrame.showKategoriFrame();
        }
    }
    
}
