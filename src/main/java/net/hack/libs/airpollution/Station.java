/*
 * The MIT License
 *
 * Copyright 2018 Bowen Peng.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.hack.libs.airpollution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.hack.libs.HttpUtils;

/**
 *
 * @author bowen
 */
public class Station {
    
    private static final Map<Integer, String[]> info = new LinkedHashMap<>();
    private static final String INFOURL = "coordonnees-stations-rsqa.csv";
    
    private static void init() {
        if (!info.isEmpty()) { //Already initialised
            return;
        }
        try {
            Path infoPath = Paths.get(INFOURL);
            Files.lines(infoPath).forEachOrdered((s) -> {
                List<String> infoList = HttpUtils.parseCsvLine(s);
                try {
                    int id = Integer.parseInt(infoList.get(0));
                    info.put(id, infoList.toArray(new String[0]));
                } catch (NumberFormatException ex) {
                }
            });
        } catch (IOException ex) {
        }
    }
    
    
    /**
     * Available pollutants.
     * <li>{@link #NO2} <br/> Nitrogen Dioxide</li>
     * <li>{@link #O3} <br/> Ozone</li>
     * <li>{@link #PM} <br/> Fine Particulate Matter (PM<sub>2.5</sub>)</li>
     * <li>{@link #SO2} <br/> Sulfur Dioxide</li>
     * <li>{@link #CO} <br/> Carbon Monoxide</li>
     */
    public static enum Pollutant {

        /** Nitrogen Dioxide */
        NO2, 
        /** Ozone */
        O3, 
        /** Fine Particulate Matter (PM<sub>2.5</sub>) */
        PM, 
        /** Sulfur Dioxide */
        SO2, 
        /** Carbon Monoxide */
        CO;
        
        /**
         * @return AQI reference value for the pollutant in grams per centimetre cubed. (g/cm<sup>3</sup>) <br/>
         * See <a href="http://donnees.ville.montreal.qc.ca/dataset/rsqa-indice-qualite-air">Montreal RSQA</a>
         */
        public double getAqiReference() {
            switch (this) {
                case SO2:
                    return 500d / 1000000d;
                case CO:
                    return 35d / 1000d;
                case O3:
                    return 160d / 1000000d;
                case NO2:
                    return 400d / 1000000d;
                case PM:
                    return 35d / 1000000d;
            }
            return 1;
        }
    }
    /**
     * Available unit formats.
     * <li>{@link #AQI} <br/> Air Quality Index</li>
     * <li>{@link #RELATIVE} <br/> Relative Air Quality</li>
     * <li>{@link #GPM3} <br/>  Pollutant quantity in gram per centimetre cubed. (g/cm<sup>3</sup>)</li>
     */
    public static enum Unit {
        /**
         * Air Quality Index <br/>
         * See <a href="http://www.iqa.mddefp.gouv.qc.ca/contenu/calcul_en.htm">Air Quality Index</a> for more information about AQI. (External Link)
         */
        AQI,
        /**
         * Relative Air Quality <br/>
         * Similar to {@link #AQI}, but is divided by 50.
         */
        RELATIVE,
        /**
         * Pollutant quantity in gram per centimetre cubed. (g/cm<sup>3</sup>)
         */
        GPM3;
    }
    
    private final int id;
    private final Map<Pollutant, LinkedList<Integer>> dataMap;

    protected Station(int id, EnumMap<Pollutant, LinkedList<Integer>> dataMap) {
        this.id = id;
        this.dataMap = dataMap;
    }
    
    /**
     * Checks if station contains data for the specified pollutant.
     * @param pollutant
     * @return true if station has data.
     */
    public boolean hasData(Pollutant pollutant) {
        return !getData(pollutant).isEmpty();
    }
    
    /**
     * @return Set containing all the tracked pollutants for this station.
     */
    public Set<Pollutant> getDataTypeSet() {
        return new HashSet<>(dataMap.keySet());
    }
    
    /**
     * Gets the recorded data for this station in AQI unit type, ordered by sampling time. <br/>
     * Sampling starts at 0:00 and is usually in intervals of one hour. <br/><br/>
     * Note: Value will be -1 if data was unavailable at that time and the List's length might be smaller than 24 if the day is not yet finished. <br/><br/>
     * See <a href="http://www.iqa.mddefp.gouv.qc.ca/contenu/calcul_en.htm">Air Quality Index</a> for more information about AQI. (External Link)
     * @return map of recorded data for this station with respect to pollutants, ordered by sampling time.
     */
    public Map<Pollutant, LinkedList<Integer>> getData() {
        return dataMap;
    }
    
    /**
     * Gets the recorded data for the specific pollutant in AQI unit type, ordered by sampling time. <br/>
     * Sampling starts at 0:00 and is usually in intervals of one hour. <br/><br/>
     * Note: Value will be -1 if data was unavailable at that time and the List's length might be smaller than 24 if the day is not yet finished. <br/><br/>
     * See <a href="http://www.iqa.mddefp.gouv.qc.ca/contenu/calcul_en.htm">Air Quality Index</a> for more information about AQI. (External Link)
     * @param pollutant
     * @return list of recorded data for the specific pollutant, ordered by sampling time.
     */
    public LinkedList<Integer> getData(Pollutant pollutant) {
        if (dataMap.containsKey(pollutant)) {
            return dataMap.get(pollutant);
        } else {
            return new LinkedList<>();
        }
    }
    
    /**
     * Converts the raw AQI data value into another unit type. <br/><br/>
     * See <a href="http://www.iqa.mddefp.gouv.qc.ca/contenu/calcul_en.htm">Air Quality Index</a> for more information about AQI. (External Link)
     * @param aqi value in AQI
     * @param unit unit to convert to
     * @param pollutant pollutant type of AQI data
     * @return converted value in the specified unit type.
     */
    public static double convert(double aqi, Unit unit, Pollutant pollutant) {
        switch (unit) {
            case AQI:
                return aqi;
            case RELATIVE:
                return aqi / 50d;
            case GPM3:
                return (aqi / 50d) * pollutant.getAqiReference();
        }

        return aqi;
    }
    
    /**
     * @return ID of station.
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return Name of station. (Human Readable)
     */
    public String getName() {
        init();
        if (info.containsKey(id)) {
            String[] infoArray = info.get(id);
            return infoArray[1];
        } else {
            return "Unknown";
        }
    }
    
    /**
     * @return Address of station. (Human Readable)
     */
    public String getAddress() {
        init();
        if (info.containsKey(id)) {
            String[] infoArray = info.get(id);
            return infoArray[2];
        } else {
            return "Unknown";
        }
    }
    
    /**
     * @return Borough of station. (Human Readable)
     */
    public String getBorough() {
        init();
        if (info.containsKey(id)) {
            String[] infoArray = info.get(id);
            return infoArray[3];
        } else {
            return "Unknown";
        }
    }
    
    /**
     * @return Latitude of station.
     */
    public double getLatitude() {
        init();
        if (info.containsKey(id)) {
            String string = info.get(id)[4];
            return Double.parseDouble(string);
        } else {
            return 0d;
        }
    }
    
    /**
     * @return Longitude of station.
     */
    public double getLongitude() {
        init();
        if (info.containsKey(id)) {
            String string = info.get(id)[5];
            return Double.parseDouble(string);
        } else {
            return 0d;
        }
    }

    @Override
    public String toString() {
        return getId() + " (" + getName() + ") " + getDataTypeSet().toString();
    }
    
    /**
     * @return Human-readable information of station.
     */
    public String getFullInfo() {
        return getId() + " (" + getName() + ") " + getDataTypeSet().toString() + " (" + getAddress() + " " + getBorough() + ") (" + getLatitude() + ", " + getLongitude() + ")";
    }
    
    
}
