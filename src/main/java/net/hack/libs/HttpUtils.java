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
package net.hack.libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author bowen
 */
public interface HttpUtils {
    
    /**
     * Parses a XML string into a XML Document
     * @param xmlString an xml-formatted string
     * @return a XML Document representing the xml string
     */
    public static Document parseXml(String xmlString) {
        try {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        Document doc = dBuilder.parse(new InputSource(new StringReader(xmlString)));
        doc.normalize();
        return doc;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            return null;
        }
    }
    
    /**
     * Sends an HTTP Request
     * @param urlString url target of request
     * @return result of the request
     * @throws MalformedURLException
     * @throws IOException
     */
    public static String httpRequest(String urlString) throws MalformedURLException, IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        
        String s;
        String output = null;
        
        while ((s = reader.readLine()) != null) { //Read until string is empty
            if (output == null) {
                output = s;
            } else {
                output += "\n" + s; //Newline
            }
        }
        reader.close();
        connection.disconnect();
        return output;
    }

    public static List<String> parseCsvLine(String string) {
        boolean isInQuote = false;
        String currentString = "";
        LinkedList<String> stringList = new LinkedList<>();
        for (char c : string.toCharArray()) {
            if (isInQuote) {
                if (c == '"') {
                    isInQuote = false;
                } else {
                    currentString += c;
                }
            } else {
                if (c == ',') {
                    stringList.add(currentString);
                    currentString = "";
                } else if (c == '"') {
                    isInQuote = true;
                } else {
                    currentString += c;
                }
            }
        }
        stringList.add(currentString);
        return stringList;
    }
}
