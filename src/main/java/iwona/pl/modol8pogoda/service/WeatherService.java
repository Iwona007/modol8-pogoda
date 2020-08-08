package iwona.pl.modol8pogoda.service;

import iwona.pl.modol8pogoda.model.WeatherDb;
import iwona.pl.modol8pogoda.model.WeatherFirst;
import iwona.pl.modol8pogoda.repository.WeatherDbRepo;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    public static final String API_KEY = "e9b2575536ca76b89b2a192098466b5d";
    private String city = "Wroclaw";
    private LocalDateTime date = LocalDateTime.now();
    private WeatherDbRepo weatherDbRepo;
    private WeatherDb weatherDb;

    @Autowired
    public WeatherService(WeatherDbRepo weatherDbRepo) {
        this.weatherDbRepo = weatherDbRepo;
        Double temp = getWeatherInfo().getMain().getTemp();
        Double tempMin = getWeatherInfo().getMain().getTempMin();
        Double tempMax = getWeatherInfo().getMain().getTempMax();
        Integer pressure = getWeatherInfo().getMain().getPressure();
        weatherDb = new WeatherDb(city, pressure, temp, tempMin, tempMax, date);
        save();
    }

    public WeatherFirst getWeatherInfo() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherFirst weather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="
                        + getCity() + "&appid=" + API_KEY,
                WeatherFirst.class);
        return weather;
    }

    public String getCity() {
        return city;
    }

    public String getIcon() {
        String icon = getWeatherInfo().getWeather().get(0).getIcon();
        return "http://openweathermap.org/img/wn/" + icon + "@2x.png";
    }

    public void save() {
        weatherDbRepo.save(weatherDb);
    }

    public List<WeatherDb> getAll() {
        return weatherDbRepo.findAll();
    }
}

