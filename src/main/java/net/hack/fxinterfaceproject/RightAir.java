/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.Random;

/**
 *
 * @author panbe
 */
public class RightAir extends Right{

    public RightAir() {
        super();
        InfoAir infoAir = new InfoAir();
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");

        
        
        Random random = new Random(0);
        int min = 0;
        int max = 9;
        
        String[][] array = new String[100][100];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
//                String color = "#"+Integer.toString(random.nextInt(max - min + 1) + min)
//                        +Integer.toString(random.nextInt(max - min + 1) + min)
//                        +Integer.toString(random.nextInt(max - min + 1) + min)
//                        +Integer.toString(random.nextInt(max - min + 1) + min)
//                        +Integer.toString(random.nextInt(max - min + 1) + min)
//                        +Integer.toString(random.nextInt(max - min + 1) + min);
                
                String color = new String("#FFFFFF");
                array[i][j] = color;
            }
        }
        Grapher2D grapher = new Grapher2D(array);
        this.getChildren().add(grapher);
        

        infoAir.setLayoutY(50);
        infoAir.setLayoutX(130);
        //this.getChildren().add(infoAir);

    }
    
    
}
