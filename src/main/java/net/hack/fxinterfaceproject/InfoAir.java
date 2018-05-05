/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Emmanuelle
 */
public class InfoAir extends StackPane{
    
    Label icone = new Label();
    
    Text texteAir = new Text("Selon l’Organisation mondiale de la Santé (OMS), 9 personnes sur 10 respiraient un air\n"
            + " avec un taux élevé de polluants. De plus, l’exposition aux particules fines, qui endommage le système \n"
            + " respiratoire et cardiovasculaire, est responsable d’environ 7 millions de morts chaque année.");
    
    public InfoAir(){
        
        Image rose = new Image(ClassLoader.getSystemResourceAsStream("rose.png"));
        
        this.setMaxSize(1200, 150);//Était 1500 850
        this.setPrefSize(1200, 150);//Était 1500 850
        this.setStyle("-fx-background-color: #333333;");
        
        
        icone.setMaxSize(50, 50);
        icone.setStyle("-fx-background-color: transparent;");
        icone.setGraphic(new ImageView(rose));
        
        texteAir.setFont(Font.font("verdana", 24));
        texteAir.setFill(Color.WHITE);
        texteAir.setTextAlignment(TextAlignment.CENTER);
        
        icone.setLayoutX(-60);
        icone.setLayoutY(40);
        
        this.getChildren().add(icone);
        this.getChildren().add(texteAir);
    }
 
}
