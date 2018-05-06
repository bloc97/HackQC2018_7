/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author panbe
 */
public class Right extends Pane {

    
    
    public Right() {
        
        Text accueil = new Text("Bienvenue sur GéoLit!");
        Text sousAccueil = new Text("L’application qui vous fait connaître l’évolution environnementale des quartiers vous entourant.");
        
        accueil.setFont(Font.font("verdana", 24));
        accueil.setFill(Color.WHITE);
        accueil.setTextAlignment(TextAlignment.CENTER);
        
        this.setVisible(true);
        this.setLayoutX(95);
        this.setLayoutY(FinaleMaster.TOP_VGAP);
        this.setMaxSize(1520, 850);//Était 1500 850
        this.setPrefSize(1520, 850);//Était 1500 850
        this.setStyle("-fx-background-color: #1F1F1F;");
        
        this.getChildren().add(accueil);
        this.getChildren().add(sousAccueil);
    }
    
    
}
