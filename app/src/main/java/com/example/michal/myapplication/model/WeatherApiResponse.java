package com.example.michal.myapplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by michal on 28.06.16.
 */
public class WeatherApiResponse {


    @Getter
    @Setter
    private City city;

    @Getter
    @Setter
    private int cod;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private int cnt;

    @Getter
    @Setter
    private List<Weather> list;

    @Getter
    @Setter
    @JsonProperty("dt_txt")
    private String dt_txt;


}
