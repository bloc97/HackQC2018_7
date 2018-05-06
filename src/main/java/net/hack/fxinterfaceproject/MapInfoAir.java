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
public class MapInfoAir extends Pane {

    public MapInfoAir() {
        
 
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.load("https://www.google.ca/maps");
        browser.setPrefSize(700, 700);
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.setPrefSize(700,700);
        //root.setMinSize(700,800);
        root.setLayoutX(40);
        root.setLayoutY(80);
        root.getChildren().addAll(browser);
        this.getChildren().add(root);
    }
  
}
