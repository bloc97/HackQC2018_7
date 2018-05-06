/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.layout.Pane;

/**
 *
 * @author panbe
 */
public class Right extends Pane {

    
    
    public Right() {

        this.setVisible(true);
        this.setLayoutX(95);
        this.setLayoutY(FinaleMaster.TOP_VGAP);
        this.setMaxSize(1520, 850);//Était 1500 850
        this.setPrefSize(1520, 850);//Était 1500 850
        this.setStyle("-fx-background-color: #1F1F1F;");
        
    }
    
    
}
