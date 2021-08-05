package telegramBot.telegramBot.services;

import telegramBot.telegramBot.weatherElements.Result;

import java.io.IOException;

public interface WeatherAPI {

    Result getResponse(String message) throws IOException;
    String getWeatherInfo(String message);
}