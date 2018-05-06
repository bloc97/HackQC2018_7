/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import java.util.Random;
import javafx.scene.image.Image;
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
    
    String[] tipArray = new String[4];
    Random random = new Random(System.currentTimeMillis());
     
    
    public InfoAir(){
        
        tipArray[0] = ("Selon l’Organisation mondiale de la Santé (OMS),\n9 personnes sur 10 respiraient un air\n"
            + " avec un taux élevé de polluants. De plus, l’exposition\n aux particules fines, qui endommage le système \n"
            + " respiratoire et cardiovasculaire, est responsable\n d’environ 7 millions de morts chaque année.");
        
        Image rose = new Image(ClassLoader.getSystemResourceAsStream("rose.png"));
        
        this.setMaxSize(700, 200);//Était 1500 850
        this.setPrefSize(700, 200);//Était 1500 850
        this.setStyle("-fx-background-color: #333333;");
        
        Text texteAir = new Text(tipArray[0]);
        
        texteAir.setFont(Font.font("verdana", 24));
        
        texteAir.setFill(Color.WHITE);
        texteAir.setTextAlignment(TextAlignment.CENTER);
        
        this.getChildren().add(texteAir);
    }
 
}