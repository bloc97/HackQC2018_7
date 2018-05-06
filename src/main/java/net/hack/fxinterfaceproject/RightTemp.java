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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
    ComboBox cb = new ComboBox();
    static Tile tile = new Tile(Tile.SkinType.DONUT_CHART);
    static Tile tileSmoothedChar;
    //po
    AirPollutionAPI aapi = new AirPollutionAPI();

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
        cb.setLayoutY(360);
        
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

        cb.setOnAction((e) -> {
           
            String region;
            region = cb.getValue().toString();
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
             
             
           /* switch (region) {
                case ("Aéroport de Montréal Dorval"):
                    indice = 7;
                    break;
                case ("Caserne 17"):
                    indice = 2;
                    break;
                case ("Chénier"):
                    indice = 1;
                    break;
                case ("Échangeur Décarie"):
                    indice = 3;
                    break;
                case ("Hochelaga-Maisonneuve"):
                    indice = 5;
                    break;
                case ("Rivière-des-Prairies"):
                    indice = 6;
                    break;
                case ("Rosemont/La Petite-Patrie"):
                    indice = 8;
                    break;
                case ("Sainte-Anne-de-Bellevue"):
                    indice = 9;
                    break;
                case ("Saint-Jean-Baptiste"):
                    indice = 0;
                    break;

            }
            
           */
            //this.getChildren().add(tile2);
            //tile = tile2;
            
            
        });
        
        
            
            
            /*
             tileSmoothedChar = TileBuilder.create()
                .prefSize(400, 300)
                .skinType(Tile.SkinType.SMOOTHED_CHART)
                .chartType(ChartType.AREA)
                .series(series1)
                .build();
            
            DayData data = null;
            try {
            double poO3;
            XYChart.Series<String, Number> seriesO3 = new XYChart.Series();
            seriesO3.setName("O3 dans l'air durant la semaine");
            data = aapi.getDay(18,05,06);
            poO3 = Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.O3).getLast(), Station.Unit.AQI, Station.Pollutant.O3);
            seriesO3.getData().add(new XYChart.Data("06", poO3));
            data = aapi.getDay(18,05,05);
            poO3 = Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.O3).getLast(), Station.Unit.AQI, Station.Pollutant.O3);
            seriesO3.getData().add(new XYChart.Data("05", poO3));
            data = aapi.getDay(18,05,04);
            poO3 = Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.O3).getLast(), Station.Unit.AQI, Station.Pollutant.O3);
            seriesO3.getData().add(new XYChart.Data("04", poO3));
            data = aapi.getDay(18,05,03);
            poO3 = Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.O3).getLast(), Station.Unit.AQI, Station.Pollutant.O3);
            seriesO3.getData().add(new XYChart.Data("03", poO3));
            data = aapi.getDay(18,05,02);
            poO3 = Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.O3).getLast(), Station.Unit.AQI, Station.Pollutant.O3);
            seriesO3.getData().add(new XYChart.Data("02", poO3));
            data = aapi.getDay(18,05,01);
            poO3 = Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.O3).getLast(), Station.Unit.AQI, Station.Pollutant.O3);
            seriesO3.getData().add(new XYChart.Data("01", poO3));
            data = aapi.getDay(18,04,30);
            poO3 = Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.O3).getLast(), Station.Unit.AQI, Station.Pollutant.O3);
            seriesO3.getData().add(new XYChart.Data("30", poO3));
            
           
                data = aapi.getDay();
            } catch (IOException ex) {
                Logger.getLogger(RightTemp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //whipe old data
            tile = new Tile(Tile.SkinType.DONUT_CHART);
            this.getChildren().add(tile);
            
            tile.addChartData(new ChartData("CO", Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.CO).getLast(), Station.Unit.AQI, Station.Pollutant.CO), Color.DARKGRAY));
            tile.addChartData(new ChartData("SO2", Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.SO2).getLast(), Station.Unit.AQI, Station.Pollutant.SO2), Color.DARKVIOLET));
            tile.addChartData(new ChartData("NO2", Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.NO2).getLast(), Station.Unit.AQI, Station.Pollutant.NO2), Color.DARKSLATEBLUE));
            tile.addChartData(new ChartData("PM", Station.convert(data.getStationList().get(indice).getData(Station.Pollutant.PM).getLast(), Station.Unit.AQI, Station.Pollutant.PM), Color.DARKORANGE));
            
            for (Station.Pollutant p : Station.Pollutant.values()) {
             //   for (int i = 0; i < Station.Pollutant.values().length;i++) {
                if (data.getStationList().get(indice).hasData(p)) {
                   // System.out.println(p + ": " + Station.convert(data.getStationList().get(indice).getData(p).getLast(), Station.Unit.AQI, p));
                }
            }

        });

        

        */

        tile.setPrefSize(300, 300);
        tile.setLayoutX(770);
        tile.setLayoutY(450);

        tileSmoothedChar.setLayoutX(1100);
        tileSmoothedChar.setLayoutY(450);

        this.getChildren().add(tileSmoothedChar);
        this.getChildren().add(tile);

        choix.setFont(Font.font("verdana", 24));
        choix.setTextFill(Color.WHITE);
        choix.setLayoutX(950);
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
        this.getChildren().add(mapInfoAir);
        this.getChildren().add(cb);
        this.getChildren().add(infoAir);
    }

}
