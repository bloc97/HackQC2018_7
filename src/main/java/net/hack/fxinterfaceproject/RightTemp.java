/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.control.ComboBox;

/**
 *
 * @author panbe
 */
public class RightTemp extends Right {

    public RightTemp() {
        super();
        InfoTemp infoTemp = new InfoTemp();
        ComboBox cb = new ComboBox();
        cb.getItems().add("Aéroport de Montréal Dorval");
        cb.getItems().add("Caserne 17");
        cb.getItems().add("Chénier");
        cb.getItems().add("Échangeur Décarie");
        cb.getItems().add("Hochelaga-Maisonneuve");
        cb.getItems().add("Rivière-des-Prairies");
        cb.getItems().add("Rosemont/La Petite-Patrie");
        cb.getItems().add("Sainte-Anne-de-Bellevue");
        cb.getItems().add("Saint-Jean-Baptiste");
        
        cb.setStyle("-fx-background-color: white;");
        cb.setLayoutX(600);
        cb.setLayoutY(250);
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");
        infoTemp.setLayoutY(50);
        infoTemp.setLayoutX(130);
        this.getChildren().add(cb);
        this.getChildren().add(infoTemp);
    }
    
}
