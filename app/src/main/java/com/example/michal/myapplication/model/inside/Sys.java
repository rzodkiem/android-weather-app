package com.example.michal.myapplication.model.inside;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by michal on 28.06.16.
 */
public class Sys {

    @JsonProperty("population")
    @Getter
    @Setter
    private int population;


}
