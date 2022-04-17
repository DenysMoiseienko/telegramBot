package com.dns.telegramBot.weatherElements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {

    @JsonProperty("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }
}
