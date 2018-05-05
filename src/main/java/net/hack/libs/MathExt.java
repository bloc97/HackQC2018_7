/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.libs;

import static java.lang.Math.*;

/**
 *
 * @author bowen
 */
public class MathExt {
    public static double PI2 = PI*2d;
    public static double PIU2 = 2d/PI;
    public static double PIO2 = PI/2d;
    public static double PIO4 = PI/4d;
    public static double SQRT2 = sqrt(2d);
    
    public static double sec(double a) {
        return 1d / cos(a);
    }
    public static double csc(double a) {
        return 1d / sin(a);
    }
    public static double cot(double a) {
        return 1d / tan(a);
    }
    
    public static double ln(double a) {
        return log(a);
    }
}
