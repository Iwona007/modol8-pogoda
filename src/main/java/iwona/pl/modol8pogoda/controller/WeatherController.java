package iwona.pl.modol8pogoda.controller;


import iwona.pl.modol8pogoda.model.WeatherDb;
import iwona.pl.modol8pogoda.service.WeatherReadingService;
import iwona.pl.modol8pogoda.service.WeatherService;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class WeatherController {

    private WeatherService weatherService;
    private WeatherReadingService weatherReadingService;

    public WeatherController(WeatherService weatherService, WeatherReadingService weatherReadingService) {
        this.weatherService = weatherService;
        this.weatherReadingService = weatherReadingService;
    }

    @GetMapping
    public List<WeatherDb> getAll() {
        return weatherService.getAll();
    }

    @Scheduled(cron = "0 * * * * ?")
    public void saveTemp() {
       weatherReadingService.saveTemp(weatherReadingService.getCurrentTemp("Wroclaw"));
    }
}
