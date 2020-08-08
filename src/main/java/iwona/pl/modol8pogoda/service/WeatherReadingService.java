package iwona.pl.modol8pogoda.service;

import iwona.pl.modol8pogoda.model.WeatherDb;
import iwona.pl.modol8pogoda.repository.WeatherDbRepo;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class WeatherReadingService {
    private WeatherService weatherService;
    private WeatherDbRepo weatherDbRepo;

    public WeatherReadingService(WeatherService weatherService, WeatherDbRepo weatherDbRepo) {
        this.weatherService = weatherService;
        this.weatherDbRepo = weatherDbRepo;
    }

    public void saveTemp(WeatherDb weather) {
        weatherDbRepo.save(weather);
    }

    public WeatherDb getCurrentTemp(String city) {
        WeatherDb readWeather = new WeatherDb();
        readWeather.setDate(LocalDate.now());
        readWeather.setName(city);
        readWeather.setTemp(weatherService.getWeatherInfo().getMain().getTemp());
        readWeather.setTempMin(weatherService.getWeatherInfo().getMain().getTempMin());
        readWeather.setTempMax(weatherService.getWeatherInfo().getMain().getTempMax());
        readWeather.setPressure(weatherService.getWeatherInfo().getMain().getPressure());
        return readWeather;
    }
}

