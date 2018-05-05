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

import net.hack.libs.HttpUtils;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import net.hack.libs.UrlBuilder;

/**
 *
 * @author bowen
 */
public class AirPollutionAPI {

    private static final String URL = "http://ville.montreal.qc.ca/rsqa/servlet/makeXmlActuel";
    
    /**
     * @return air pollution data in Montreal for the current day.
     * @throws IOException
     */
    public DayData getDay() throws IOException {
        UrlBuilder builder = new UrlBuilder(URL);
        return getDay(builder.getUrl());
    }
    
    /**
     * @param date from 2007/01/01 to now.
     * @return air pollution data in Montreal for the specified date.
     * @throws IOException
     */
    public DayData getDay(Date date) throws IOException {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return getDay(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
    }
    
    /**
     * @param year from 2007 to now.
     * @param month from 1 to 12.
     * @param day from 1 to end of month.
     * @return air pollution data in Montreal for the specified date.
     * @throws IOException
     */
    public DayData getDay(int year, int month, int day) throws IOException {
        UrlBuilder builder = new UrlBuilder(URL);
        builder.append("date", stringifyDate(year) + stringifyDate(month) + stringifyDate(day));
        return getDay(builder.getUrl());
    }
    
    
    private String stringifyDate(int i) {
        String s = Integer.toString(i);
        switch (s.length()) {
            case 0:
                return "00";
            case 1:
                return "0" + s;
            case 2:
                return s;
            default:
                return s.substring(s.length() - 2);
        }
    }
    
    private DayData getDay(String string) throws IOException {
        String response = HttpUtils.httpRequest(string);
        Document doc = HttpUtils.parseXml(response);
        
        Element dayElement = (Element)doc.getElementsByTagName("journee").item(0);
        
        int day = Integer.parseInt(dayElement.getAttribute("jour"));
        int month = Integer.parseInt(dayElement.getAttribute("mois"));
        int year = Integer.parseInt(dayElement.getAttribute("annee"));
        
        Map<Integer, Station> stations = new LinkedHashMap<>();
        
        NodeList stationList = doc.getElementsByTagName("station");
        for (int i=0; i<stationList.getLength(); i++) {
            Node stationNode = stationList.item(i);
            if (stationNode instanceof Element) {
                Element stationElement = (Element) stationNode;
                
                int id = Integer.parseInt(stationElement.getAttribute("id"));
                EnumMap<Station.Pollutant, LinkedList<Integer>> dataMap = new EnumMap<>(Station.Pollutant.class);
                
                NodeList pollutantList = stationElement.getElementsByTagName("polluant");
                
                for (int j=0; j<pollutantList.getLength(); j++) {
                    Node pollutantNode = pollutantList.item(j);
                    if (pollutantNode instanceof Element) {
                        Element pollutantElement = (Element) pollutantNode;
                        
                        Station.Pollutant pollutant = Station.Pollutant.valueOf(pollutantElement.getAttribute("nom"));
                        int value = Integer.parseInt(pollutantElement.getAttribute("value"));
                        int hour = Integer.parseInt(((Element)pollutantElement.getParentNode()).getAttribute("heure"));
                        
                        if (!dataMap.containsKey(pollutant)) {
                            dataMap.put(pollutant, new LinkedList<>());
                        }
                        
                        List<Integer> dataList = dataMap.get(pollutant);
                        
                        while (hour > dataList.size()) {
                            dataMap.get(pollutant).add(dataList.size(), -1);
                        }
                        
                        if (hour > dataList.size()) {
                            System.out.println(year + " " + month + " " + day + " " + id);
                            System.out.println(hour + " " + dataList.size());
                            throw new IllegalStateException("Hours not in order!");
                        }
                        
                        dataMap.get(pollutant).add(hour, value);
                        
                    }
                }
                
                stations.put(id, new Station(id, dataMap));
            }
            
        }
        
        return new DayData(day, month, year, stations);
        
    }
    
}
