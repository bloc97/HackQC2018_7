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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import net.hack.libs.MontrealUtils;
import net.hack.libs.airpollution.AirPollutionAPI;
import net.hack.libs.airpollution.DayData;
import net.hack.libs.airpollution.Station;

/**
 *
 * @author panbe
 */
public class RightTemp extends Right {

    static int  counter = 1;
    Label titreEtude = new Label("QUANTITÉ DE POLLUANTS DANS L'AIR");
    Label choix = new Label("Choix de secteur: ");
    //ComboBox cb = new ComboBox();
    Label l = new Label("None");
    static Tile tile = new Tile(Tile.SkinType.DONUT_CHART);
    static Tile tileSmoothedChar;
    //po
    AirPollutionAPI aapi = new AirPollutionAPI();

    public RightTemp() {
        super();
        InfoAir infoAir = new InfoAir();
        MapInfoAir mapInfoAir = new MapInfoAir();
/*
        cb.getItems().add("Aéroport de Montréal Dorval");
        cb.getItems().add("Caserne 17");
        cb.getItems().add("Chénier");
        cb.getItems().add("Échangeur Décarie");
        cb.getItems().add("Hochelaga-Maisonneuve");
        cb.getItems().add("Rivière-des-Prairies");
        cb.getItems().add("Rosemont/La Petite-Patrie");
        cb.getItems().add("Sainte-Anne-de-Bellevue");
        cb.getItems().add("Saint-Jean-Baptiste");

        cb.setStyle("-fx-background-color: white;");*/
        l.setLayoutX(900);
        l.setLayoutY(360 + 40);
        //l.setStyle("-fx-background-color: white;");
        l.setStyle("-fx-color: white;");
        l.setTextFill(Color.WHITE);
        l.setFont(Font.font("verdana", 24));
        
        XYChart.Series<String, Number> series1 = new XYChart.Series();
        series1.setName("O3 dans l'air durant la semaine");
        series1.getData().add(new XYChart.Data("L", 23));
        series1.getData().add(new XYChart.Data("Ma", 24));
        series1.getData().add(new XYChart.Data("Me", 18));
        series1.getData().add(new XYChart.Data("J", 16));
        series1.getData().add(new XYChart.Data("V", 22));
        series1.getData().add(new XYChart.Data("S", 24));
        series1.getData().add(new XYChart.Data("D", 19));
        
         tileSmoothedChar = TileBuilder.create()
                .prefSize(350, 300)
                .skinType(Tile.SkinType.SMOOTHED_CHART)
                .chartType(ChartType.AREA)
                .series(series1)
                .build();

        
        tile.addChartData(new ChartData("CO", 48, Color.DARKGRAY));
        tile.addChartData(new ChartData("SO2", 32, Color.DARKVIOLET));
        tile.addChartData(new ChartData("NO2", 13, Color.DARKSLATEBLUE));
        tile.addChartData(new ChartData("PM", 82, Color.DARKORANGE));
        tile.addChartData(new ChartData("NONE", 120, Color.BLACK));

        
        mapInfoAir.root.canvas.setOnMouseClicked((event) -> {
            int x = (int)event.getX();
            int y = (int)event.getY();
            int id = MontrealUtils.quartierImage.getPixelReader().getArgb(x, y) & (0xFF);
            
            l.setText(MontrealUtils.quartiers.getOrDefault(id, "None"));
            
            String region;
            region = l.toString();
            int indice = 0;
            
             
            //Tile tile2 = new Tile(Tile.SkinType.DONUT_CHART);
             
                tile.clearChartData();
                tile.addChartData(new ChartData("CO", Math.random(), Color.DARKGRAY));
                tile.addChartData(new ChartData("SO2", Math.random(), Color.DARKVIOLET));
                tile.addChartData(new ChartData("NO2", Math.random(), Color.DARKSLATEBLUE));
                tile.addChartData(new ChartData("PM", Math.random(), Color.DARKORANGE));
                tile.addChartData(new ChartData("O3", Math.random()*2 +23, Color.BLACK));
            tileSmoothedChar.clearChartData();
            series1.getData().add(new XYChart.Data("L", Math.random()*2 +23));
            series1.getData().add(new XYChart.Data("Ma",Math.random()*2 +23));
            series1.getData().add(new XYChart.Data("Me", Math.random()*2 +23));
            series1.getData().add(new XYChart.Data("J", Math.random()*2 +23));
            series1.getData().add(new XYChart.Data("V", Math.random()*2 +23));
            series1.getData().add(new XYChart.Data("S", Math.random()*2 +23));
            series1.getData().add(new XYChart.Data("D", Math.random()*2 +23));
            /*DayData data;
            try {
                data = aapi.getDay();
            } catch (IOException ex) {
                
            }*/
            

        });
        this.getChildren().add(mapInfoAir);
            

        tile.setPrefSize(300, 300);
        tile.setLayoutX(770);
        tile.setLayoutY(450);

        tileSmoothedChar.setLayoutX(1100);
        tileSmoothedChar.setLayoutY(450);

        this.getChildren().add(tileSmoothedChar);
        this.getChildren().add(tile);

        choix.setFont(Font.font("verdana", 24));
        choix.setTextFill(Color.WHITE);
        choix.setLayoutX(850);
        choix.setLayoutY(360);

        titreEtude.setFont(Font.font("verdana", 40));
        titreEtude.setLayoutY(20);
        titreEtude.setLayoutX(40);
        titreEtude.setTextFill(Color.web("#FF0066"));

        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");
        infoAir.setLayoutY(95);
        infoAir.setLayoutX(770);
        this.getChildren().add(titreEtude);
        this.getChildren().add(choix);
        //this.getChildren().add(mapInfoAir);
        this.getChildren().add(l);
        this.getChildren().add(infoAir);
    }

}
