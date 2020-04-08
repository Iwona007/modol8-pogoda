package iwona.pl.modol8pogoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Modol8PogodaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Modol8PogodaApplication.class, args);
    }

}
