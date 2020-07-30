package com.example.Activity;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class WeatherServer {


    public void connectServer(String city) {
        HttpsURLConnection connection;
        BufferedReader in = null;
        try{
            URL link = new URL("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
            connection = (HttpsURLConnection)link.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (MalformedURLException | ProtocolException m) {
            System.out.println(m.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}