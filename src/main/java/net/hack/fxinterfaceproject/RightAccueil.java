/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Emmanuelle
 */
public class RightAccueil extends Right{
    
    RightAccueil(){
        
        super();
    
        Text accueil = new Text("Bienvenue sur GéoLit!");
        Text sousAccueil = new Text("L’application qui vous fait connaître l’évolution environnementale des quartiers vous entourant.");
        
        accueil.setFont(Font.font("verdana",FontWeight.BOLD, 96));
        accueil.setFill(Color.web("#6ED0E0"));
        accueil.setTextAlignment(TextAlignment.CENTER);
        
        accueil.setLayoutY(270);
        accueil.setLayoutX(170);
        
        sousAccueil.setFont(Font.font("verdana", 27));
        sousAccueil.setFill(Color.BLACK);
        sousAccueil.setTextAlignment(TextAlignment.CENTER);
        
        sousAccueil.setLayoutY(350);
        sousAccueil.setLayoutX(95);
        
        
        this.setVisible(true);
        this.setStyle("-fx-background-color: #f2f2f2;");
        
        this.getChildren().add(accueil);
        this.getChildren().add(sousAccueil);
    
    }
    
}
