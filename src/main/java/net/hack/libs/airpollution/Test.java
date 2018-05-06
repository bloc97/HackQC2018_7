package net.hack.libs.airpollution;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.util.Pair;
import javax.imageio.ImageIO;
import net.hack.libs.GeoUtils;

/**
 *
 * @author bowen
 */
public class Test {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
//        Pair<Double, Double> pair1 = GeoUtils.polarToLambertConic(-0.7d, 0.2d, 0, 0, 0.05d, 0.15d);
//        Pair<Double, Double> pair2 = GeoUtils.lambertConicToPolar(pair1.getKey(), pair1.getValue(), 0, 0, 0.05d, 0.15d);
//        
//        Pair<Double, Double> topLeft = GeoUtils.polarToLambertConic(49.76234d*Math.PI/180, -79.5142d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
//        Pair<Double, Double> bottomLeft = GeoUtils.polarToLambertConic(44.65949d*Math.PI/180, -78.41124d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
//        Pair<Double, Double> topRight = GeoUtils.polarToLambertConic(50.22866d*Math.PI/180, -64.22754d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
//        Pair<Double, Double> bottomRight = GeoUtils.polarToLambertConic(45.07587d*Math.PI/180, -64.66043d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
//        
//        //System.out.println(GeoUtils.polarToLambertConic(47.67585d*Math.PI/180, -71.72765d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180));
//        
//        BufferedImage image = ImageIO.read(new File("chaleur_3000_17438_24241.png"));
//        
//        double x0 = topLeft.getKey();
//        double y0 = topLeft.getValue();
//        
//        double width = bottomRight.getKey() - x0;
//        double height = bottomRight.getValue() - y0;
//        
//        double xr = 0.320345d;
//        double yr = 0.847173d;
//        
//        double x1 = x0 + width * xr;
//        double y1 = y0 + height * yr;
//        
//        Pair<Double, Double> pairTest = GeoUtils.lambertConicToPolar(x1, y1, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
//        
//        System.out.println(pairTest.getKey() * 180d / Math.PI + " " + pairTest.getValue() * 180d / Math.PI);
//        
//        System.out.println(image.getWidth());

        //System.out.println(pair2.getKey() + " " + pair2.getValue());
        
        AirPollutionAPI aapi = new AirPollutionAPI();
        
        //DayData data = aapi.getDay(13, 10, 25);
        DayData data = aapi.getDay();
        System.out.println(data);
        System.out.println(data.getStationList());
        
        System.out.println("Station " + data.getStationList().get(0).getId());
        
        for (Station.Pollutant p : Station.Pollutant.values()) {
            if (data.getStationList().get(0).hasData(p)) {
                System.out.println(p + ": " + Station.convert(data.getStationList().get(0).getData(p).getLast(), Station.Unit.AQI, p));
            }
        }
        
    }
}
