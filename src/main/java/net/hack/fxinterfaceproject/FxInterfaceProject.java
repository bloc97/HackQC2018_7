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
        
        
        
        Pane root = new Pane();
        //root.getChildren().add(btn);
        
        Top top = new Top(primaryStage);
        Right right = new Right();
        right.setVisible(false);
        
        RightAir rightAir = new RightAir();
        RightTree rightTree = new RightTree();
        RightTemp rightTemp = new RightTemp();
        Left left = new Left(rightAir,rightTree,rightTemp);
        root.getChildren().add(rightAir);
        root.getChildren().addAll(top,right,left,rightTree,rightTemp);
        
        top.setLayoutX(0);
        top.setLayoutY(0);
        left.setLayoutX(0);
        left.setLayoutY(FinaleMaster.TOP_VGAP);
        root.setMaxSize(1600, 900);

        Scene scene = new Scene(root, 1600, 900);
        
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
