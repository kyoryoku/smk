package lab.smk.models.journals;

import lab.smk.models.Document;
import lab.smk.models.system.Employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lab_pinumber")
public class PINumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, mappedBy="piNumber")
    private Document document;

    private String number;
    private LocalDate date;

    public PINumber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
