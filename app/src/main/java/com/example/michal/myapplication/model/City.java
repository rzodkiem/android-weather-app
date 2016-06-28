package com.example.michal.myapplication.model;

import com.example.michal.myapplication.model.inside.Coordination;
import com.example.michal.myapplication.model.inside.Sys;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by michal on 27.06.16.
 */
public class City {


    @JsonProperty("country")
    @Getter
    @Setter
    private String countryCode;

    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonProperty("id")
    @Getter
    @Setter
    private long id;

    @JsonProperty("coord")
    @Getter
    @Setter
    private Coordination coordination;

    @JsonProperty("sys")
    @Getter
    @Setter
    private Sys sys;

    @Getter
    @Setter
    @JsonProperty("population")
    private int population;


}
