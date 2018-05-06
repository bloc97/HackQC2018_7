/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author panbe
 */
public class Top extends Pane {

    Label title = new Label("HackQc18");
    Button buttonCancel = new Button("");
    Button buttonMini = new Button("");
    
    private static double xOffset = 0;
    private static double yOffset = 0;

    public Top(Stage primaryStage) {

        Image cancel = new Image(ClassLoader.getSystemResourceAsStream("cancel.png"));
        Image cancel1 = new Image(ClassLoader.getSystemResourceAsStream("cancel1.png"));
        Image mini = new Image(ClassLoader.getSystemResourceAsStream("mini.png"));
        Image mini1 = new Image(ClassLoader.getSystemResourceAsStream("mini1.png"));
        
         title.setFont(Font.font("verdana", FontWeight.BOLD, 48));
         title.setTextFill(Color.web("#6ED0E0"));
        
         this.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
            
        });
        
        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
         
        //<editor-fold defaultstate="collapsed" desc="buttonCancel">
        buttonCancel.setMaxSize(50, 50);
        buttonCancel.setStyle("-fx-background-color: transparent;");
        buttonCancel.setGraphic(new ImageView(cancel));
        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
            // boolean isCancel = true;
            @Override
            public void handle(ActionEvent e) {

                primaryStage.close();

            }

        });

        buttonCancel.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonCancel.setGraphic(new ImageView(cancel1));
                    }
                });

        buttonCancel.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonCancel.setGraphic(new ImageView(cancel));  
                    }
                });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="buttonMini">
        buttonMini.setMaxSize(50, 50);
        buttonMini.setStyle("-fx-background-color: transparent;");
        buttonMini.setGraphic(new ImageView(mini));
        buttonMini.setOnAction(new EventHandler<ActionEvent>() {
            // boolean isCancel = true;
            @Override
            public void handle(ActionEvent e) {

               primaryStage.setIconified(true);

            }

        });

        buttonMini.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonMini.setGraphic(new ImageView(mini1));
                    }
                });

        buttonMini.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonMini.setGraphic(new ImageView(mini));  
                    }
                });
        //</editor-fold>
        
        buttonCancel.setLayoutX(1530);//Était 1490
        buttonCancel.setLayoutY(5);
        
        buttonMini.setLayoutX(1470);//Était 1390
        buttonMini.setLayoutY(5);
        
        title.setLayoutX(10);
        
        this.getChildren().add(buttonCancel);
        this.getChildren().add(buttonMini);
        this.getChildren().add(title);
        
        this.setMaxSize(1600, 70); //Était 1600, 100
        this.setPrefSize(1600, 70);//Était 1600, 100
        this.setStyle("-fx-background-color: #333333;");
        //A8D08A vert pale
        //A0C19C vert fonce
    }

}
