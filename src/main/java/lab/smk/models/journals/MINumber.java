package lab.smk.models.journals;

import lab.smk.models.Document;
import lab.smk.models.system.Employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lab_minumber")
public class MINumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, mappedBy="document")
    private Document document;

    private String number;
    private LocalDate date;
    private Employee employee;

    public MINumber() {
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "MINumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", employee=" + employee +
                '}';
    }
}
