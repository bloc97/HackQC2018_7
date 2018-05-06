/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
    
    Text texteTemp = new Text("Les arbres ont une grande capacité à absorber le CO2 et produire de l’oxygène,"
            + "en plus de capturer d’autres \npolluants atmosphériques, dont les particules"
            + "fines, produites par les véhicules et le chauffage des bâtiments.");
    String[] tipArray = new String[4];
    Random random = new Random(System.currentTimeMillis());
    
    Button btnInfo = new Button("");
    
    public InfoTree(){
        
        Image infoV = new Image(ClassLoader.getSystemResourceAsStream("infoVert.png"));
        
        btnInfo.setMaxSize(50, 50);
        btnInfo.setStyle("-fx-background-color: transparent;");
        btnInfo.setGraphic(new ImageView(infoV));
        
        btnInfo.setLayoutY(20);
        btnInfo.setLayoutX(830);
        
        this.setMaxSize(1400, 90);//Était 1500 850
        this.setPrefSize(1400, 90);//Était 1500 850
        this.setStyle("-fx-background-color: #333333;");
        
        tipArray[0] = ("Les arbres ont une grande capacité à absorber le CO2 et produire de l’oxygène,"
                + "en plus de capturer d’autres \npolluants atmosphériques, dont les particules"
                + "fines, produites par les véhicules et le chauffage des bâtiments.");
        tipArray[1] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                + " Mauris eget scelerisque tortor, ac porttitor metus. Sed diam nibh,"
                + " feugiat vitae ante eu, tempor porta velit. Mauris mi quam, ullamcorper sed elit vitae, gravida dignissim arcu. "
                + " Vestibulum metus mi, interdum eget mi id, eleifend auctor nibh. ";
        tipArray[2] = "Duis non risus sit amet tortor convallis gravida. Sed varius tempor tellus non imperdiet."
                + " Nullam vitae massa eget velit tristique egestas. ";
        tipArray[3] = "Quisque sit amet urna blandit, lobortis turpis in, maximus ipsum. ";
        
        
        int max = 3;
        int min = 0;
        
        
        btnInfo.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                Text texteTemp = new Text(tipArray[(random.nextInt(max - min + 1) + min)]);
            }
            
        });
        
        texteTemp.setFont(Font.font("verdana", 24));
        texteTemp.setFill(Color.WHITE);
        texteTemp.setTextAlignment(TextAlignment.CENTER);

        
        this.getChildren().add(texteTemp);
      //  this.getChildren().add(btnInfo);
    }
}
