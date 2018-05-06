/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

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

    public Left(Right right,RightAir rightAir, RightTree rightTree, RightTemp rightTemp) {
        //consulte les codes dans Top.java
        
        Image air = new Image(ClassLoader.getSystemResourceAsStream("vent.png"));
        Image air1 = new Image(ClassLoader.getSystemResourceAsStream("vent1.png"));
        
        Image arbre = new Image(ClassLoader.getSystemResourceAsStream("feuille.png"));
        Image arbre1 = new Image(ClassLoader.getSystemResourceAsStream("feuille1.png"));
        
        Image temperature = new Image(ClassLoader.getSystemResourceAsStream("thermo.png"));
        Image temperature1 = new Image(ClassLoader.getSystemResourceAsStream("thermo1.png"));
        
 
        
        
        //<editor-fold defaultstate="collapsed" desc="buttonOne">
        buttonOne.setMaxSize(50, 50);
        buttonOne.setStyle("-fx-background-color: transparent;");
        buttonOne.setGraphic(new ImageView(air));
        
        buttonOne.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                right.setVisible(false);
                rightAir.setVisible(true);
                rightTree.setVisible(false);
                rightTemp.setVisible(false);
                System.out.println("Triggered");
            }
            
        });
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
        buttonTwo.setMaxSize(50, 50);
        buttonTwo.setStyle("-fx-background-color: transparent;");
        buttonTwo.setGraphic(new ImageView(arbre));
        
        buttonTwo.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                right.setVisible(false);
                rightAir.setVisible(false);
                rightTree.setVisible(true);
                rightTemp.setVisible(false);
            }
            
        });
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
        buttonThree.setMaxSize(50, 50);
        buttonThree.setStyle("-fx-background-color: transparent;");
        buttonThree.setGraphic(new ImageView(temperature));
        
        buttonThree.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                right.setVisible(false);
                rightAir.setVisible(false);
                rightTree.setVisible(false);
                rightTemp.setVisible(true);
            }
            
        });
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
        
        buttonOne.setLayoutY(30);
        buttonTwo.setLayoutY(130);
        buttonThree.setLayoutY(230);
        buttonOne.setLayoutX(15);
        buttonTwo.setLayoutX(10);
        buttonThree.setLayoutX(12);
       
        this.getChildren().add(buttonOne);
        this.getChildren().add(buttonTwo);
        this.getChildren().add(buttonThree);
        
         
        this.setMaxSize(95, 850);
        this.setPrefSize(95, 850);
        this.setStyle("-fx-background-color: #4D4D4D;");
        
    }
    
}
