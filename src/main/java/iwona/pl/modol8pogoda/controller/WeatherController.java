package iwona.pl.modol8pogoda.controller;


import iwona.pl.modol8pogoda.model.WeatherDb;
import iwona.pl.modol8pogoda.service.WeatherService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<WeatherDb> getAll() {
        return weatherService.getAll();
    }
    
}
