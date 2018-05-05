/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.libs;

import javafx.util.Pair;
import static java.lang.Math.*;
import static net.hack.libs.MathExt.*;

/**
 *
 * @author bowen
 */
public class GeoUtils {
    
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
