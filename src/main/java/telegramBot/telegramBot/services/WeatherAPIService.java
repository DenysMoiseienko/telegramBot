package telegramBot.telegramBot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import telegramBot.telegramBot.weatherElements.Result;
import telegramBot.telegramBot.weatherElements.Weather;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

@Service
public class WeatherAPIService implements WeatherAPI{

    @Value("${open.weather.map.id}")
    private String appId;

    @Override
    public Result getResponse(String message) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message +
                "&units=metric&appid=" + appId);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, Result.class);
    }

    @Override
    public String getWeatherInfo(String message) {
        if (message.equals("/start")) {
            return "Hi, I am a Simple Bot, send me title of city and I will say you about the weather:)";
        }
        try {
            return createString(getResponse(message));
        }catch (FileNotFoundException e) {
            return "Sorry, but I not found this city:(";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private String createString(Result result) {
        String main = result.getName();
        String temp = result.getMain().getTemp() + "C";
        String description = "";
        for (Weather w : result.getWeather()) {
            description = w.getDescription();
        }
        return "City: " + main + "\n" +
                "Temperature: " + temp + "\n" +
                "Description: " + description;
    }
}
