package telegramBot.telegramBot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import telegramBot.telegramBot.weatherElements.Result;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

@Service
public class WeatherAPIService implements WeatherAPI{

    @Value("${open.weather.map.id}")
    private String appId;

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public Result getResponse(String message) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message +
                "&units=metric&appid=" + appId);
        return new ObjectMapper().readValue(url, Result.class);
    }

    @Override
    public String getWeatherInfo(String message) {
        try {
            return createString(getResponse(message));
        }catch (FileNotFoundException e) {
            return messageSource.getMessage("notFound", null, null);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private String createString(Result result) {
        String main = result.getName();
        double temp = result.getMain().getTemp();
        String description = result.getWeather().stream().findFirst().get().getDescription();
        int pressure = result.getMain().getPressure();
        int humidity = result.getMain().getHumidity();

        return "<i>City: </i><b>" + main + "</b>\n" +
                "<i>Temperature: </i><b>" + temp + " C</b>\n" +
                "<i>Description: </i><b>" + description + "</b>\n" +
                "<i>Pressure: </i><b>" + pressure + " Pa</b>\n" +
                "<i>Humidity: </i><b>" + humidity + "%</b>";
    }
}