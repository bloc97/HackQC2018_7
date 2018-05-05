/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author Emmanuelle
 */
public class MapInfo extends Pane {

    public MapInfo() {
        
 
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.load("https://www.google.ca/maps");
 
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.setPrefSize(1400,650);
        root.setLayoutX(40);
        root.setLayoutY(200);
        root.getChildren().addAll(browser);
        this.getChildren().add(root);
    }
 
        
    
    
        
    
}
