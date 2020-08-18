package lab.smk.models.journals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private double temp;
    private double pres;
    private double hum;

    public Weather(Date date, double temp, double pres, double hum) {
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
