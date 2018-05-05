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
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author panbe
 */
public class Grapher2D extends Pane {
    
    private static double lastX = 0;
    private static double lastY = 0;
    
    private final Canvas canvas;
    private GraphicsContext gc;
    Image image;
    
    private double scale = 1d;
    
    public Grapher2D(Image image) {
        this.image = image;
        this.canvas = new Canvas(image.getWidth(), image.getHeight());
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);

       //gc.setFill(Color.web("#0000FF"));
       // gc.setFill(Color.BLUE);
       // gc.fillRect(75,75,1,1);
        
        
        Pane thisPane = this;
        
        this.getChildren().add(canvas);
        
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                lastX = event.getScreenX();
                lastY = event.getScreenY();
            }
            
        });
        
        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                //thisPane.setLayoutX(event.getScreenX() + xOffset);
                //thisPane.setLayoutY(event.getScreenY() + yOffset);
                gc.translate(event.getScreenX() - lastX, event.getScreenY() - lastY);
                lastX = event.getScreenX();
                lastY = event.getScreenY();
                
                
            }
        });
        
        this.setOnScroll((event) -> {
            double d = event.getDeltaY();
            if (d < 0) {
                gc.scale(0.9d, 0.9d);
            } else {
                gc.scale(1.1d, 1.1d);
            }
            zoom(canvas, event);
            //gc.fillRect(-1000, -1000, 8000, 8000);
            //gc.drawImage(image, 0, 0);
        });
        
        
        
        this.setVisible(true);
        this.setPrefSize(1500, 850);
    }
    /*
    public void grapheArray(int magnRate) {
        for (int i = 0; i < arrayLocal.length; i++) {
            for (int j = 0; j < arrayLocal[0].length; j++) {
                
                gc.setFill(Color.web(arrayLocal[i][j]));
                gc.fillRect(i*magnRate,j*magnRate,magnRate,magnRate);
            }
        }
    }*/
    public static void zoom(Node node, double factor, double x, double y) {
        double oldScale = node.getScaleX();
        double scale = oldScale * factor;
        if (scale < 0.05) scale = 0.05;
        if (scale > 50)  scale = 50;
        node.setScaleX(scale);
        node.setScaleY(scale);

        double  f = (scale / oldScale)-1;
        Bounds bounds = node.localToScene(node.getBoundsInLocal());
        double dx = (x - (bounds.getWidth()/2 + bounds.getMinX()));
        double dy = (y - (bounds.getHeight()/2 + bounds.getMinY()));

        node.setTranslateX(node.getTranslateX()-f*dx);
        node.setTranslateY(node.getTranslateY()-f*dy);
    }

    public static void zoom(Node node, ScrollEvent event) {
        zoom(node, Math.pow(1.01, event.getDeltaY()), event.getSceneX(), event.getSceneY());
    }
    public static void zoom(Node node, ZoomEvent event) {
        zoom(node, event.getZoomFactor(), event.getSceneX(), event.getSceneY());
    }
    
}
