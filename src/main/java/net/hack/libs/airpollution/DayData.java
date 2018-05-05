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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bowen
 */
public class DayData {
    
    private final Map<Integer, Station> stationMap;
    private final int day;
    private final int month;
    private final int year;

    protected DayData(int day, int month, int year, Map<Integer, Station> stationMap) {
        this.stationMap = stationMap;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * @return all the stations in a list.
     */
    public List<Station> getStationList() {
        return new ArrayList<>(stationMap.values());
    }
    
    /**
     * @return the specified station.
     */
    public Station getStation(int id) {
        return stationMap.get(id);
    }
    
    /**
     * Checks if the specified station exists.
     * @param id station ID
     * @return true if station exists.
     */
    public boolean hasStation(int id) {
        return stationMap.containsKey(id);
    }

    /**
     * @return the day.
     */
    public int getDay() {
        return day;
    }

    /**
     * @return the month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return the year.
     */
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day + " " + stationMap.keySet();
    }
    
}
