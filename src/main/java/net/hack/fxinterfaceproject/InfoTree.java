/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import java.util.Random;
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
    
    String[] tipArray = new String[4];
    Random random = new Random(System.currentTimeMillis());
    
    
    
    public InfoTree(){
        
        this.setMaxSize(1000, 150);//Était 1500 850
        this.setPrefSize(1000, 150);//Était 1500 850
        this.setStyle("-fx-background-color: #333333;");
        
        tipArray[0] = ("Les arbres ont une grande capacité à absorber le CO2 et produire de l’oxygène, \n"
            + "en plus de capturer d’autres polluants atmosphériques, dont les particules\n"
            + " fines, produites par les véhicules et le chauffage des bâtiments.");
        tipArray[1] = "";
        tipArray[2] = "";
        tipArray[3] = "";
        
        
        int max = 3;
        int min = 0;
        Text texteTemp = new Text(tipArray[(random.nextInt(max - min + 1) + min)]);
        
        texteTemp.setFont(Font.font("verdana", 24));
        texteTemp.setFill(Color.WHITE);
        texteTemp.setTextAlignment(TextAlignment.CENTER);

        this.getChildren().add(texteTemp);
    }
}
