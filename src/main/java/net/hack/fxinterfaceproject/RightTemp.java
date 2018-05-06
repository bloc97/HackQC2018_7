/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.Tile.ChartType;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.chart.ChartData;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author panbe
 */
public class RightTemp extends Right {
    
    Label titreEtude = new Label("QUANTITÉ DE POLLUANTS DANS L'AIR");
    Label choix = new Label("Choix de secteur: ");
    ComboBox cb = new ComboBox();
    public RightTemp() {
        super();
        InfoAir infoAir = new InfoAir();
        MapInfoAir mapInfoAir = new MapInfoAir();
        
        cb.getItems().add("Aéroport de Montréal Dorval");
        cb.getItems().add("Caserne 17");
        cb.getItems().add("Chénier");
        cb.getItems().add("Échangeur Décarie");
        cb.getItems().add("Hochelaga-Maisonneuve");
        cb.getItems().add("Rivière-des-Prairies");
        cb.getItems().add("Rosemont/La Petite-Patrie");
        cb.getItems().add("Sainte-Anne-de-Bellevue");
        cb.getItems().add("Saint-Jean-Baptiste");
        
        cb.setStyle("-fx-background-color: white;");
        cb.setLayoutX(1200);
        cb.setLayoutY(100);
        
        cb.setOnAction((e) -> {
             //System.out.println(comboBox.getSelectionModel().getSelectedItem());
             System.out.println(cb.getValue());
        });
        
        XYChart.Series<String, Number> series1 = new XYChart.Series();
        series1.setName("O3 dans l'air durant la semaine");
        series1.getData().add(new XYChart.Data("L",23));
        series1.getData().add(new XYChart.Data("Ma",24));
        series1.getData().add(new XYChart.Data("Me",18));
        series1.getData().add(new XYChart.Data("J",16));
        series1.getData().add(new XYChart.Data("V",22));
        series1.getData().add(new XYChart.Data("S",24));
        series1.getData().add(new XYChart.Data("D",19));
        
        Tile tileSmoothedChar = TileBuilder.create()
                .prefSize(500, 250)
                .skinType(Tile.SkinType.SMOOTHED_CHART)
                .chartType(ChartType.AREA)
                .series(series1)
                .build();
        
        
        
        Tile tile = new Tile(Tile.SkinType.DONUT_CHART);
        tile.addChartData(new ChartData("CO", 48, Color.DARKGRAY));
        tile.addChartData(new ChartData("SO2", 32, Color.DARKVIOLET));
        tile.addChartData(new ChartData("NO2", 13, Color.DARKSLATEBLUE));
        tile.addChartData(new ChartData("PM", 82, Color.DARKORANGE));
        tile.addChartData(new ChartData("NONE", 120, Color.BLACK));
        
        tile.setPrefSize(330, 330);
        
        tile.setLayoutX(1020);
        tile.setLayoutY(450);
        
        tileSmoothedChar.setLayoutX(930);
        tileSmoothedChar.setLayoutY(170);
        
        this.getChildren().add(tileSmoothedChar);
        this.getChildren().add(tile);
        
        choix.setFont(Font.font("verdana", 24));
        choix.setTextFill(Color.WHITE);
        choix.setLayoutX(950);
        choix.setLayoutY(95);
        
        titreEtude.setFont(Font.font("verdana", 40));
        titreEtude.setLayoutY(20);
        titreEtude.setLayoutX(40);
        titreEtude.setTextFill(Color.web("#FF0066"));
        
        
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");
        infoAir.setLayoutY(50);
        infoAir.setLayoutX(130);
        this.getChildren().add(titreEtude);
        this.getChildren().add(choix);
        this.getChildren().add(mapInfoAir);
        this.getChildren().add(cb);
        //this.getChildren().add(infoAir);
    }
    
}
