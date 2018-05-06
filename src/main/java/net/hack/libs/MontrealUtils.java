/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.libs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author bowen
 */
public class MontrealUtils {
    
    private static final String QUARTIERSURL = "quartiers.csv";
    private static final String QUARTIERSMAPURL = "mapQuartiers.png";
    private static final String CHALEURMAPURL = "chaleur_3000_17438_24241.png";
    
    public static final Image quartierImage = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream(QUARTIERSMAPURL));
    public static final Map<Integer, String> quartiers = getQuartiers();
    
    public static Map<Integer, String> getQuartiers() {
        Map<Integer, String> quartierMap = new LinkedHashMap<>();
        try {
            Path infoPath = Paths.get(QUARTIERSURL);
            Files.lines(infoPath).forEachOrdered((s) -> {
                List<String> infoList = HttpUtils.parseCsvLine(s);
                try {
                    int id = Integer.parseInt(infoList.get(1));
                    quartierMap.put(id, infoList.get(0));
                } catch (NumberFormatException ex) {
                }
            });
        } catch (IOException ex) {
       }
        
        return quartierMap;
    }
    
    public static Map<Integer, Double> computeQuartiersTempScore() {
        Image chaleurImage = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream(CHALEURMAPURL));
        
        Map<Integer, String> quartiers = getQuartiers();
        Map<Integer, Double> scoreSum = new LinkedHashMap<>();
        Map<Integer, Long> scoreN = new LinkedHashMap<>();
        
        
        System.out.println(quartiers);
        for (int j=0; j<quartierImage.getHeight(); j++) {
            for (int i=0; i<quartierImage.getWidth(); i++) {
                int x = quartierImage.getPixelReader().getArgb(i, j) & (0xFF);
                if (quartiers.containsKey(x)) {
                    if (!scoreSum.containsKey(x)) {
                        scoreSum.put(x, 0d);
                        scoreN.put(x, 0l);
                    }
                    
                    double score = chaleurImage.getPixelReader().getColor(i, j).getGreen();
                    scoreSum.put(x, scoreSum.get(x) + score);
                    scoreN.put(x, scoreN.get(x) + 1);
                }
            }
        }
        
        for (int i : quartiers.keySet()) {
            scoreSum.put(i, scoreSum.get(i) / scoreN.get(i));
        }
        
        return scoreSum;
    }
    
    public static Image colorQuartiers(Map<Integer, Integer> quartierColorMap) {
        Image image = new Image(ClassLoader.getSystemClassLoader().getResourceAsStream(QUARTIERSMAPURL));
        
        WritableImage cimage = new WritableImage((int)image.getWidth(), (int)image.getHeight());
        
        PixelReader imageReader = image.getPixelReader();
        PixelWriter imageWriter = cimage.getPixelWriter();
        
        for (int j=0; j<image.getHeight(); j++) {
            for (int i=0; i<image.getWidth(); i++) {
                int x = imageReader.getArgb(i, j) & (0xFF);
                if (quartierColorMap.containsKey(x)) {
                    int y = quartierColorMap.get(x) | (255 << 24);
                    imageWriter.setArgb(i, j, y);
                }
            }
        }
        
        return cimage;
    }
    
    
    
}
