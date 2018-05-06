/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.libs;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.util.Pair;
import static java.lang.Math.*;
import javax.imageio.ImageIO;
import static net.hack.libs.MathExt.*;

/**
 *
 * @author bowen
 */
public class GeoUtils {
    
    
    public static final Pair<Double, Double> getPolar(double x, double y) {
        Pair<Double, Double> topLeft = GeoUtils.polarToLambertConic(49.76234d*Math.PI/180, -79.5142d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
        Pair<Double, Double> bottomLeft = GeoUtils.polarToLambertConic(44.65949d*Math.PI/180, -78.41124d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
        Pair<Double, Double> topRight = GeoUtils.polarToLambertConic(50.22866d*Math.PI/180, -64.22754d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
        Pair<Double, Double> bottomRight = GeoUtils.polarToLambertConic(45.07587d*Math.PI/180, -64.66043d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);

        double x0 = topLeft.getKey();
        double y0 = topLeft.getValue();
        
        double width = bottomRight.getKey() - x0;
        double height = bottomRight.getValue() - y0;
        
        double xr = x/3000d;
        double yr = y/3000d;
        
        double x1 = x0 + width * xr;
        double y1 = y0 + height * yr;
        
        Pair<Double, Double> pairTest = GeoUtils.lambertConicToPolar(x1, y1, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
        
        return pairTest;
    }
    
    public static final Pair<Double, Double> getCoord(double latitude, double longitude) {
        Pair<Double, Double> topLeft = GeoUtils.polarToLambertConic(49.76234d*Math.PI/180, -79.5142d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
        Pair<Double, Double> bottomLeft = GeoUtils.polarToLambertConic(44.65949d*Math.PI/180, -78.41124d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
        Pair<Double, Double> topRight = GeoUtils.polarToLambertConic(50.22866d*Math.PI/180, -64.22754d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
        Pair<Double, Double> bottomRight = GeoUtils.polarToLambertConic(45.07587d*Math.PI/180, -64.66043d*Math.PI/180, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);

        double x0 = topLeft.getKey();
        double y0 = topLeft.getValue();
        
        double width = bottomRight.getKey() - x0;
        double height = bottomRight.getValue() - y0;
        
        Pair<Double, Double> pairTest = GeoUtils.polarToLambertConic(latitude, longitude, -68.5d*Math.PI/180, 44d*Math.PI/180, 46d*Math.PI/180, 60d*Math.PI/180);
        
        double xr = (pairTest.getKey() - x0) / width;
        double yr = (pairTest.getValue() - y0) / height;
        
        double x = xr * 3000;
        double y = yr * 3000;
        
        return new Pair<>(x, y);
        
    }
    
    /**
     *
     * @param p latitude
     * @param l longitude
     * @param l0
     * @param p0
     * @param p1
     * @param p2
     * @return x, y
     */
    public static final Pair<Double, Double> polarToLambertConic(double p, double l, double l0, double p0, double p1, double p2) {
        
        double n = 0;
        if (p1 == p2) {
            n = sin(p1);
        } else {
            n = ln(cos(p1) * sec(p2)) / ln(tan(PIO4 + p2/2d) * cot(PIO4 + p1/2d));
        }
        
        double f = cos(p1) * pow(tan(PIO4 + p1/2d), n) / n;
        
        double r = f * pow(cot(PIO4 + p/2d), n);
        double r0 = f * pow(cot(PIO4 + p0/2d), n);
        
        double x = r * sin(n * (l - l0));
        double y = r0 - r * cos(n * (l - l0));
        
        return new Pair<>(x, y);
        
    }
    
    public static final Pair<Double, Double> lambertConicToPolar(double x, double y, double l0, double p0, double p1, double p2) {
        
        double n = 0;
        if (p1 == p2) {
            n = sin(p1);
        } else {
            n = ln(cos(p1) * sec(p2)) / ln(tan(PIO4 + p2/2d) * cot(PIO4 + p1/2d));
        }
        
        double f = cos(p1) * pow(tan(PIO4 + p1/2d), n) / n;
        
        double r0 = f * pow(cot(PIO4 + p0/2d), n);
        
        double xsqr = x * x;
        double ry = r0 - y;
        double rysqr = ry * ry;
        double r = signum(n) * sqrt(xsqr + rysqr);
        
        double l = l0 + atan(x/(r0-y))/n;
        double p = 2d * atan(pow(f/r, 1d/n)) - PIO2;
        
        return new Pair<>(p, l);
    }
    
    
    
    
}
