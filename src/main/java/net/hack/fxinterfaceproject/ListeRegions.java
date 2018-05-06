/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author Emmanuelle
 */
public class ListeRegions extends Pane{
    
    ListeRegions(){
        ComboBox cb = new ComboBox();
        cb.getItems().add("Montréal Nord");
        cb.getItems().add("Outremont");
        cb.getItems().add("Plateau Mont-Royal");
        cb.getItems().add("Beaconsfield");
        cb.getItems().add("ALLO");
    
    }
    
}
