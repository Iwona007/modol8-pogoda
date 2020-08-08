package iwona.pl.modol8pogoda.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "weathers_db")
public class WeatherDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer pressure;
    private Double temp;
    @Column(name = "temp_min")
    private Double tempMin;
    @Column(name = "temp_max")
    private Double tempMax;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    public WeatherDb() {
    }

    public WeatherDb(String name) {
        this.name = name;
    }

    public WeatherDb(String name, Integer pressure, Double temp,
                     Double tempMin, Double tempMax, LocalDateTime dateTime) {
        this.name = name;
        this.pressure = pressure;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "WeatherDb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pressure=" + pressure +
                ", temp=" + temp +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", dateTime=" + dateTime +
                '}';
    }
}
