/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.fxinterfaceproject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;
import javax.imageio.ImageIO;
import net.hack.libs.GeoUtils;
import net.hack.libs.airpollution.AirPollutionAPI;
import net.hack.libs.airpollution.DayData;
import net.hack.libs.airpollution.Station;

/**
 *
 * @author panbe
 */
public class RightAir extends Right{

    
    public static Pair<Station, Double> getClosestStation(double latitude, double longitude, List<Station> stationList) {
        double distance = Double.POSITIVE_INFINITY;
        Station closestStation = null;
        
        
        for (Station s : stationList) {
            double diffLat = s.getLatitude() - latitude;
            double diffLong = s.getLongitude() - longitude;
            
            double distanceSqr = diffLat * diffLat + diffLong * diffLong;
            
            if (distanceSqr < distance) {
                distance = distanceSqr;
                closestStation = s;
            }
            
        }
        
        return new Pair<>(closestStation, distance);
    }
    
    public RightAir() {
        super();
        InfoAir infoAir = new InfoAir();
        this.setVisible(false);
        this.setStyle("-fx-background-color: #1F1F1F;");

        
        
        Image image = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream("chaleur_3000_17438_24241.png"));
        /*
        WritableImage image2 = new WritableImage((int)image.getWidth(), (int)image.getHeight());
        DayData data;
        try {
            data = new AirPollutionAPI().getDay();
            
            Map<Integer, Integer> maxValueMap = new LinkedHashMap<>();
            List<Station> validStationList = new LinkedList<>();
            
            for (Station s : data.getStationList()) {
                
                int maxValue = -1;
                for (Map.Entry<Station.Pollutant, LinkedList<Integer>> entry : s.getData().entrySet()) {
                    int value = entry.getValue().getLast();
                    if (value > maxValue) {
                        maxValue = value;
                    }
                }
                
                if (maxValue != -1) {
                    maxValueMap.put(s.getId(), maxValue);
                    validStationList.add(s);
                    System.out.println(s + " " + maxValue);
                }
                
            }
            for (int j=0; j<image2.getHeight(); j++) {
                for (int i=0; i<image2.getWidth(); i++) {
                    
                    Pair<Double, Double> polarCoords = GeoUtils.getPolar(i, j);
                    Pair<Station, Double> stationPair = getClosestStation(polarCoords.getKey()*180d/Math.PI, polarCoords.getValue()*180d/Math.PI, validStationList);
                    Station closestStation = stationPair.getKey();
                    double distance = stationPair.getValue();
                    //System.out.println(closestStation);
                    double groundHeat = image.getPixelReader().getColor(i, j).getRed();
                    double airPollution = Math.min(maxValueMap.getOrDefault(closestStation.getId(), 0)/50d, 1d);
                    
                    int value = Math.min((int)((groundHeat * 0.1d + airPollution * 0.9d) * 255), 255);
                    if (distance < 0.00001d) {
                        image2.getPixelWriter().setArgb(i, j, (255<<24) | 255*255*255);
                    } else {
                        image2.getPixelWriter().setArgb(i, j, (255<<24) | value<<16);
                    }
                    //System.out.println(value);
                }
                System.out.println("Generating Map: " + j/30 + " %");
            }
        } catch (IOException ex) {
            Logger.getLogger(RightAir.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        //Grapher2D grapher = new Grapher2D(image2);
        
        Grapher2D grapher = new Grapher2D(image);
        this.getChildren().add(grapher);
        
        
        
        /*
        Random random = new Random(0);
        int min = 0;
        int max = 9;
        
        String[][] array = new String[100][100];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                
                String color = "#"+Integer.toString(random.nextInt(max - min + 1) + min)
                        +Integer.toString(random.nextInt(max - min + 1) + min)
                        +Integer.toString(random.nextInt(max - min + 1) + min)
                        +Integer.toString(random.nextInt(max - min + 1) + min)
                        +Integer.toString(random.nextInt(max - min + 1) + min)
                        +Integer.toString(random.nextInt(max - min + 1) + min);
                
            //    String color = new String("#FFFFFF");
                array[i][j] = color;
            }
        }
        Grapher2D grapher = new Grapher2D(array);
        this.getChildren().add(grapher);
        */
        
        Image cancel = new Image(ClassLoader.getSystemResourceAsStream("cancel.png"));
        Image cancel1 = new Image(ClassLoader.getSystemResourceAsStream("cancel1.png"));
        
        Button buttonBig = new Button("");
        Button buttonSma = new Button("");
        //<editor-fold defaultstate="collapsed" desc="buttonBig">
        buttonBig.setMaxSize(50, 50);
        buttonBig.setStyle("-fx-background-color: transparent;");
        buttonBig.setGraphic(new ImageView(cancel));
        buttonBig.setOnAction(new EventHandler<ActionEvent>() {
            // boolean isCancel = true;
            @Override
            public void handle(ActionEvent e) {

                

            }

        });

        buttonBig.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonBig.setGraphic(new ImageView(cancel1));
                    }
                });

        buttonBig.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonBig.setGraphic(new ImageView(cancel));  
                    }
                });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="buttonSma">
        buttonSma.setMaxSize(50, 50);
        buttonSma.setStyle("-fx-background-color: transparent;");
        buttonSma.setGraphic(new ImageView(cancel));
        buttonSma.setOnAction(new EventHandler<ActionEvent>() {
            // boolean isCancel = true;
            @Override
            public void handle(ActionEvent e) {

              

            }

        });

        buttonSma.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonSma.setGraphic(new ImageView(cancel1));
                    }
                });

        buttonSma.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttonSma.setGraphic(new ImageView(cancel));  
                    }
                });
        //</editor-fold>
        

        infoAir.setLayoutY(50);
        infoAir.setLayoutX(130);
        //this.getChildren().add(infoAir);

    }
    
    
}