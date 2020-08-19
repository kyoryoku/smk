package lab.smk.models.journals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private LocalTime time;
    private double temp;
    private double pres;
    private double hum;

    /**
     * <p>Одна строка таблицы с погодой</p>
     * @param date дата добавления (LocalDate)
     * @param time время добавления (LocalTime)
     * @param temp температура (double)
     * @param pres давление (double)
     * @param hum влажность (double)
     *
     */
    public Weather(LocalDate date, LocalTime time, double temp, double pres, double hum) {
        this.date = date;
        this.time = time;
        this.temp = temp;
        this.pres = pres;
        this.hum = hum;
    }

    public Weather() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPres() {
        return pres;
    }

    public void setPres(double pres) {
        this.pres = pres;
    }

    public double getHum() {
        return hum;
    }

    public void setHum(double hum) {
        this.hum = hum;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", temp=" + temp +
                ", pres=" + pres +
                ", hum=" + hum +
                '}';
    }
}
