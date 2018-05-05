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
public class RightAir extends Right{

    public RightAir() {
        super();
        InfoAir infoAir = new InfoAir();
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");
        infoAir.setLayoutY(50);
        infoAir.setLayoutX(130);
        this.getChildren().add(infoAir);
    }
    
    
}
