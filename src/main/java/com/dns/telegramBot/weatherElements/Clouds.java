package com.dns.telegramBot.weatherElements;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "all"
})
public class Clouds {

    @JsonProperty("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }
}
