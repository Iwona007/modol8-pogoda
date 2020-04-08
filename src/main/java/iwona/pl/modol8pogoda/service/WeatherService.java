package iwona.pl.modol8pogoda.service;

import iwona.pl.modol8pogoda.model.WeatherDb;
import iwona.pl.modol8pogoda.model.WeatherFirst;
import iwona.pl.modol8pogoda.repository.WeatherDbRepo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    public static final String API_KEY = "e9b2575536ca76b89b2a192098466b5d";
    private String city = "Wroclaw";
    private LocalDate date = LocalDate.now();
    private WeatherDbRepo weatherDbRepo;
    private WeatherDb weatherDb;
    private List<WeatherDb> list;

    @Autowired
    public WeatherService(WeatherDbRepo weatherDbRepo) {
        this.weatherDbRepo = weatherDbRepo;

        Double temp = getWeatherInfo().getMain().getTemp();
        Double tempMin = getWeatherInfo().getMain().getTempMin();
        Double tempMax = getWeatherInfo().getMain().getTempMax();
        Integer humidity = getWeatherInfo().getMain().getHumidity();
        Integer pressure = getWeatherInfo().getMain().getPressure();
        Double lon = getWeatherInfo().getCoord().getLon();
        Double lat = getWeatherInfo().getCoord().getLat();
        weatherDb = new WeatherDb(city, humidity, pressure, temp, tempMin, tempMax, date,
                getIcon(), lon, lat);
        save();
        save2();

        list = new ArrayList<>();
    }

    public WeatherFirst getWeatherInfo() {
        RestTemplate restTemplate = new RestTemplate();

        WeatherFirst weather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + getCity() + "&appid=" + API_KEY,
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

    @Schedules({
            @Scheduled(cron = "0 0 * * * *"),
            @Scheduled(cron = "0 * * * * *")
//            @Scheduled(fixedDelay = 1000)
    })
    public void save2() {
        System.out.println(weatherDb.getTemp());
        weatherDbRepo.save(weatherDb);
    }

    public List<WeatherDb> getAll() {
        return weatherDbRepo.findAll();
    }

}

