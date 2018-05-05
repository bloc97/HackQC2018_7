/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxinterfaceproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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

    public Top(Stage primaryStage) {

        Image cancel = new Image(getClass().getResourceAsStream("cancel.png"));
        Image cancel1 = new Image(getClass().getResourceAsStream("cancel1.png"));
        Image mini = new Image(getClass().getResourceAsStream("mini.png"));
        Image mini1 = new Image(getClass().getResourceAsStream("mini1.png"));
        
         title.setFont(Font.font("Abel", FontWeight.BOLD, 48));
        
        
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
        
        buttonMini.setLayoutX(1470);//Était 1390
        
        title.setLayoutX(10);
        
        this.getChildren().add(buttonCancel);
        this.getChildren().add(buttonMini);
        this.getChildren().add(title);
        
        this.setMaxSize(1600, 100); //Était 1600, 100
        this.setPrefSize(1600, 100);//Était 1600, 100
        this.setStyle("-fx-background-color: #ECD275;");
        //A8D08A vert pale
        //A0C19C vert fonce
    }

}
