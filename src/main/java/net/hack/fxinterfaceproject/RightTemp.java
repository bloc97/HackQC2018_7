/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author panbe
 */
public class RightTemp extends Right {
    
    Label titreEtude = new Label("QUANTITÉ DE POLLUANTS DANS L'AIR");
    Label choix = new Label("Choix de secteur: ");
    ComboBox cb = new ComboBox();
    public RightTemp() {
        super();
        InfoAir infoAir = new InfoAir();
        MapInfoAir mapInfoAir = new MapInfoAir();
        
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
        cb.setLayoutX(1200);
        cb.setLayoutY(100);
        
        choix.setFont(Font.font("verdana", 24));
        choix.setTextFill(Color.WHITE);
        choix.setLayoutX(950);
        choix.setLayoutY(95);
        
        titreEtude.setFont(Font.font("verdana", 40));
        titreEtude.setLayoutY(20);
        titreEtude.setLayoutX(40);
        titreEtude.setTextFill(Color.web("#FF0066"));
        
        
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");
        infoAir.setLayoutY(50);
        infoAir.setLayoutX(130);
        this.getChildren().add(titreEtude);
        this.getChildren().add(choix);
        this.getChildren().add(mapInfoAir);
        this.getChildren().add(cb);
        //this.getChildren().add(infoAir);
    }
    
}
