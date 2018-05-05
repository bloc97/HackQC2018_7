/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author panbe
 */
public class FxInterfaceProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        Pane root = new Pane();
        //root.getChildren().add(btn);
        
        Top top = new Top(primaryStage);
        Right right = new Right();
        Left left = new Left();
        root.getChildren().addAll(top,right,left);
        top.setLayoutX(0);
        top.setLayoutY(0);
        right.setLayoutX(100);
        right.setLayoutY(100);
        left.setLayoutX(0);
        left.setLayoutY(100);
        root.setMaxSize(1600, 900);
        
        
        
        Scene scene = new Scene(root, 1600, 900);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
