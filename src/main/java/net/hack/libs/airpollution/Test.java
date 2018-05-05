package net.hack.libs.airpollution;

import java.io.IOException;

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
        AirPollutionAPI aapi = new AirPollutionAPI();
        
        DayData data = aapi.getDay(13, 10, 25);
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
