package com.example.michal.myapplication.model;

import com.example.michal.myapplication.model.inside.Clouds;
import com.example.michal.myapplication.model.inside.MainWeatherInfo;
import com.example.michal.myapplication.model.inside.Rain;
import com.example.michal.myapplication.model.inside.WeatherInfo;
import com.example.michal.myapplication.model.inside.Wind;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by michal on 27.06.16.
 */
public class Weather {


    @Getter
    @Setter
    private long dt;

    @Getter
    @Setter
    @JsonProperty("main")
    private MainWeatherInfo mainWeaterInfo;

    @Getter
    @Setter
    @JsonProperty("weather")
    private List<WeatherInfo> weatherInfo;

    @Getter
    @Setter
    private Clouds clouds;

    @Getter
    @Setter
    private Wind wind;

    @Getter
    @Setter
    private Rain rain;


}
