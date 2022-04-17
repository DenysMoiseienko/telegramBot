package com.dns.telegramBot.weatherElements;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lon",
        "lat"
})
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