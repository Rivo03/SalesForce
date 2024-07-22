package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Meteo {
    private static final String API_KEY = "330b20662d12092d7310e53a71540459 ";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final double LATITUDE = 45.464664;
    private static final double LONGITUDE = 9.188540;

    public static void main(String[] args) {
        try {

            JSONObject jsonResponse = getJsonObject();
            String nomeCitta = jsonResponse.getString("name");
            double temperatura = jsonResponse.getJSONObject("main").getDouble("temp");
            int umidita = jsonResponse.getJSONObject("main").getInt("humidity");
            String descrizioneTempo = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");

            System.out.println("Nome città: " + nomeCitta);
            System.out.println("Temperatura in °C: " + temperatura);
            System.out.println("Umidità: " + umidita + "%");
            System.out.println("Sintesi: " + descrizioneTempo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getJsonObject() throws IOException, JSONException {
        String urlString = String.format("%s?lat=%f&lon=%f&units=metric&appid=%s", API_URL, LATITUDE, LONGITUDE, API_KEY);
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return new JSONObject(response.toString());
    }
}
