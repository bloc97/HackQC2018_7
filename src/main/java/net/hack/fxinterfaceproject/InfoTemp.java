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
public class InfoTemp extends StackPane{
    
    Label icone = new Label();
    
    Text texteTemp = new Text("Les îlots de chaleur urbains causent une augmentation du smog et dégradent la qualité. Aussi, \n"
            + "ils créent un plus grand besoin en réfrigération, augmentant la consommation d’énergie et \n"
            + "d’eau potable.");
    
    public InfoTemp(){
        
        Image vert = new Image(ClassLoader.getSystemResourceAsStream("vert.png"));
        this.setMaxSize(1200, 150);//Était 1500 850
        this.setPrefSize(1200, 150);//Était 1500 850
        this.setStyle("-fx-background-color: #333333;");
        
        icone.setMaxSize(50, 50);
        icone.setStyle("-fx-background-color: transparent;");
        icone.setGraphic(new ImageView(vert));
        
        texteTemp.setFont(Font.font("verdana", 24));
        texteTemp.setFill(Color.WHITE);
        texteTemp.setTextAlignment(TextAlignment.CENTER);
        
        icone.setLayoutX(-60);
        icone.setLayoutY(40);
        
        this.getChildren().add(icone);
        this.getChildren().add(texteTemp);
    }
}
