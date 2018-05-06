/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import net.hack.libs.MontrealUtils;

/**
 *
 * @author Emmanuelle
 */
public class MapInfoAir extends Pane {

    
    public Grapher2D root;
    
    public MapInfoAir() {
        
        Random r = new Random(34);
        Map<Integer, Double> tempScore = MontrealUtils.computeQuartiersTempScore();
        System.out.println(tempScore);
        Map<Integer, Integer> colors = new LinkedHashMap<>();
        
        for (int i=0; i<50; i++) {
            double score = (tempScore.getOrDefault(i, 0.5d) - 0.5d) * 2d;
            
            if (score >= 0) {
                colors.put(i, (int)(Math.sqrt(Math.abs(score) * 4d) * 255) << 16 | (255 << 24));
            } else {
                colors.put(i, (int)(Math.sqrt(Math.abs(score)) * 255) << 8 | (255 << 24));
            }
            
        }
        Image image = MontrealUtils.colorQuartiers(colors);
        root = new Grapher2D(image);
        
        //VBox root = new VBox();
        root.setPadding(new Insets(5));
        //root.setSpacing(5);
        root.setPrefSize(1400,650);
        root.setLayoutX(40);
        root.setLayoutY(200);
        
        this.getChildren().add(root);
    }
  
}
