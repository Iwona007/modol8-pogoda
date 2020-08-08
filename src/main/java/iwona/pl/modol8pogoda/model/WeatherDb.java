package iwona.pl.modol8pogoda.model;


import java.time.LocalDate;
import javax.persistence.*;

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
    private LocalDate date;
    public WeatherDb() {
    }

    public WeatherDb(String name) {
        this.name = name;
    }

    public WeatherDb( String name,Integer pressure, Double temp, Double tempMin, Double tempMax, LocalDate date) {
        this.name = name;
        this.pressure = pressure;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.date=date;
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


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
                ", date=" + date +
                '}';
    }
}
