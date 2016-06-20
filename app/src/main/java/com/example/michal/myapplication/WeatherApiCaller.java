package com.example.michal.myapplication;

import org.json.JSONObject;

/**
 * Created by michal on 20.06.16.
 */
public class WeatherApiCaller {

    private static final String API_URL = "http://api.openweathermap.org/data/2.5/forecast?q=Warsaw,pl&mode=json&appid=58523522a9fbf5195662ec3a9d4b7a65";
    JSONParser jsonParser = new JSONParser();
    JSONObject getApiResponse(){
        JSONObject response = jsonParser.getJSONFromUrl(API_URL);
        return response;
    }
}
