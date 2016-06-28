package com.example.michal.myapplication.model.inside;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by michal on 27.06.16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainWeatherInfo {

    @Getter
    @Setter
    private double temp;

    @Getter
    @Setter
    @JsonProperty("temp_min")
    private double tempMin;

    @Getter
    @Setter
    @JsonProperty("temp_max")
    private double tempMax;

    @Getter
    @Setter
    private double pressure;

    @Getter
    @Setter
    @JsonProperty("sea_level")
    private double seaLevel;

    @Getter
    @Setter
    @JsonProperty("grnd_level")
    private double groundLevel;

    @Getter
    @Setter
    private double humidity;



}
