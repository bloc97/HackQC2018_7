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
public class InfoTree extends StackPane{
    
    Label icone = new Label();
    
    Text texteTemp = new Text("Les arbres ont une grande capacité à absorber le CO2 et produire de l’oxygène, \n"
            + "en plus de capturer d’autres polluants atmosphériques, dont les particules\n"
            + " fines, produites par les véhicules et le chauffage des bâtiments.");
    
    public InfoTree(){
        
        Image orange = new Image(ClassLoader.getSystemResourceAsStream("orange.png"));
        this.setMaxSize(1000, 150);//Était 1500 850
        this.setPrefSize(1000, 150);//Était 1500 850
        this.setStyle("-fx-background-color: #333333;");
        
        icone.setMaxSize(50, 50);
        icone.setStyle("-fx-background-color: transparent;");
        icone.setGraphic(new ImageView(orange));
        
        texteTemp.setFont(Font.font("verdana", 24));
        texteTemp.setFill(Color.WHITE);
        texteTemp.setTextAlignment(TextAlignment.CENTER);
        
        this.getChildren().add(icone);
        this.getChildren().add(texteTemp);
    }
}
