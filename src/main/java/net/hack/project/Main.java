/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.project;

import java.io.IOException;
import java.util.Arrays;
import net.hack.libs.airpollution.AirPollutionAPI;
import net.hack.libs.airpollution.DayData;
import net.hack.libs.airpollution.Station;

/**
 *
 * @author bowen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        AirPollutionAPI aapi = new AirPollutionAPI();
        DayData dayData = aapi.getDay(2018, 5, 3);
        
        System.out.println(dayData);
        
        Station station = dayData.getStationList().get(0);
        
        System.out.println(station);
        System.out.println(station.getData(Station.Pollutant.PM));
        
    }
    
}
