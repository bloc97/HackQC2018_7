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
        
        tipArray[0] = ("Selon l’Organisation mondiale de la Santé (OMS), 9 personnes sur 10 respiraient un air\n"
            + " avec un taux élevé de polluants. De plus, l’exposition aux particules fines, qui endommage le système \n"
            + " respiratoire et cardiovasculaire, est responsable d’environ 7 millions de morts chaque année.");
        tipArray[1] ="Sed efficitur nibh id neque aliquam, vitae sagittis risus tincidunt. ";
        tipArray[2] ="Nunc nec diam lacus. Aenean a blandit nisi. Cras posuere erat velit, "
                + "id imperdiet arcu euismod sed. Morbi quis magna vulputate dolor pharetra varius. ";
        tipArray[3] =" Phasellus sollicitudin mi at orci faucibus volutpat. "
                + "Proin finibus auctor tellus non semper. ";
        Image rose = new Image(ClassLoader.getSystemResourceAsStream("rose.png"));
        
        this.setMaxSize(1400, 90);//Était 1500 850
        this.setPrefSize(1400, 90);//Était 1500 850
        this.setStyle("-fx-background-color: #333333;");
        
        int max = 3;
        int min = 0;
        Text texteAir = new Text(tipArray[(random.nextInt(max - min + 1) + min)]);
        
        texteAir.setFont(Font.font("verdana", 24));
        
        texteAir.setFill(Color.WHITE);
        texteAir.setTextAlignment(TextAlignment.CENTER);
        
        this.getChildren().add(texteAir);
    }
 
}