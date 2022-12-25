/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.main;

/**
 *
 * @author FDL
 */
public class App {

    public static void main(String[] args) {
        MainController mainController = new MainController();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainController.showMainFrame();
            }
        });
    }
}
