package com.dns.telegramBot.weatherElements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord {

    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("lat")
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }
}