package iwona.pl.modol8pogoda.repository;

import iwona.pl.modol8pogoda.model.WeatherDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDbRepo extends JpaRepository<WeatherDb, Long> {

}
