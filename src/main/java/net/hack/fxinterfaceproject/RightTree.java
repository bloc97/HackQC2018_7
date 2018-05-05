/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

/**
 *
 * @author panbe
 */
public class RightTree extends Right {

    public RightTree() {
        super();
        MapInfo mapInfo = new MapInfo();
        InfoTree infoTree = new InfoTree();
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");
        infoTree.setLayoutY(50);
        infoTree.setLayoutX(130);
        this.getChildren().add(mapInfo);
        this.getChildren().add(infoTree);
    }
    
    
}
