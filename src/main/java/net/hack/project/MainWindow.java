/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.project;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author panbe
 */
public class MainWindow extends JFrame {

    //MainPanel mainPanel = new MainPanel();
    PanelDecorationFile panelDecoration = new PanelDecorationFile();
    
    public MainWindow() throws HeadlessException {
        
       // this.setUndecorated(true);
        
        this.setSize(1600, 900);
        this.setVisible(true);
        //this.add(mainPanel);
        this.add(panelDecoration);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
    }
    
    
    
}
