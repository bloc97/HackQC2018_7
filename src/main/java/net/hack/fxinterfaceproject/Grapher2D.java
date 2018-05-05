/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;


import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import static java.lang.Integer.parseInt;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author panbe
 */
public class Grapher2D extends Pane {
    
    private static double xOffset = 0;
    private static double yOffset = 0;

    public Grapher2D(String[][] array) {
        
        

        final Canvas canvas = new Canvas(1500, 850);
        GraphicsContext gc = canvas.getGraphicsContext2D();
       //gc.setFill(Color.web("#0000FF"));
       // gc.setFill(Color.BLUE);
       // gc.fillRect(75,75,1,1);
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                
                gc.setFill(Color.web(array[i][j]));
                gc.fillRect(i,j,1,1);
            }
        }
        
        Pane thisPane = this;
        
        this.getChildren().add(canvas);
        
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                xOffset = thisPane.getLayoutX()- event.getScreenX();
                yOffset = thisPane.getLayoutY() - event.getScreenY();
            }
            
        });
        
        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                thisPane.setLayoutX(event.getScreenX() + xOffset);
                thisPane.setLayoutY(event.getScreenY() + yOffset);
            }
        });
        
        
        
        
        
        this.setVisible(true);
        this.setPrefSize(1500, 850);
    }
    
}
