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
public class RightTemp extends Right {

    public RightTemp() {
        super();
        InfoTemp infoTemp = new InfoTemp();
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");
        infoTemp.setLayoutY(50);
        infoTemp.setLayoutX(130);
        this.getChildren().add(infoTemp);
    }
    
}
