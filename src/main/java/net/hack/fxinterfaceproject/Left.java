/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxinterfaceproject;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author panbe
 */
public class Left extends Pane{
    
    Button buttonOne = new Button("");
    Button buttonTwo = new Button("");
    Button buttonThree = new Button("");

    public Left() {
        //consulte les codes dans Top.java
        
        Image air = new Image(getClass().getResourceAsStream("air.png"));
        Image air1 = new Image(getClass().getResourceAsStream("air1.png"));
        
        Image arbre = new Image(getClass().getResourceAsStream("arbre.png"));
        Image arbre1 = new Image(getClass().getResourceAsStream("arbre1.png"));
        
        Image temperature = new Image(getClass().getResourceAsStream("temperature.png"));
        Image temperature1 = new Image(getClass().getResourceAsStream("temperature1.png"));
        
 
        
        //<editor-fold defaultstate="collapsed" desc="buttonOne">
        buttonOne.setMaxSize(100, 100);
        buttonOne.setStyle("-fx-background-color: transparent;");
        buttonOne.setGraphic(new ImageView(air));
        
        buttonOne.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonOne.setGraphic(new ImageView(air1));
                    }
                });
        
         buttonOne.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonOne.setGraphic(new ImageView(air));  
                    }
                });
         
         //</editor-fold>
      
        //<editor-fold defaultstate="collapsed" desc="buttonTwo">
        buttonTwo.setMaxSize(100, 100);
        buttonTwo.setStyle("-fx-background-color: transparent;");
        buttonTwo.setGraphic(new ImageView(arbre));
        
        buttonTwo.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonTwo.setGraphic(new ImageView(arbre1));
                    }
                });
        
         buttonTwo.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonTwo.setGraphic(new ImageView(arbre));  
                    }
                });
        //</editor-fold>
         
        //<editor-fold defaultstate="collapsed" desc="buttonThree">
        buttonThree.setMaxSize(100, 100);
        buttonThree.setStyle("-fx-background-color: transparent;");
        buttonThree.setGraphic(new ImageView(temperature));
        
        buttonThree.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonThree.setGraphic(new ImageView(temperature1));
                    }
                });
        
         buttonThree.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonThree.setGraphic(new ImageView(temperature));  
                    }
                });
        
        //</editor-fold>
        
        buttonTwo.setLayoutY(100);
        buttonThree.setLayoutY(200);
       
        this.getChildren().add(buttonOne);
        this.getChildren().add(buttonTwo);
        this.getChildren().add(buttonThree);
        
         
        this.setMaxSize(115, 850);
        this.setPrefSize(115, 850);
        this.setStyle("-fx-background-color: #A0C19C;");
        
    }
    
}
