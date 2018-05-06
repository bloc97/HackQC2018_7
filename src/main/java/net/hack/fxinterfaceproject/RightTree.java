/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author panbe
 */
public class RightTree extends Right {
    
    Label titreEtude = new Label("DENSITÉ DE LA FORESTERIE URBAINE");

    public RightTree() {
        super();
        MapInfoArbre mapInfoA = new MapInfoArbre();
        InfoTree infoTree = new InfoTree();
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");
        infoTree.setLayoutY(30);
        infoTree.setLayoutX(445);
        titreEtude.setFont(Font.font("verdana", 40));
        titreEtude.setLayoutY(20);
        titreEtude.setLayoutX(40);
        titreEtude.setTextFill(Color.web("#FF9900"));
        this.getChildren().add(titreEtude);
        this.getChildren().add(mapInfoA);
        this.getChildren().add(infoTree);
    }
    
    
}
