package lab.smk.models.journals;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lab_minumber")
public class MINumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, mappedBy="miNumber")
    private Document document;

    private String number;
    private LocalDate date;

    public MINumber() {
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

    @Override
    public String toString() {
        return "MINumber{" +
                "id=" + id +
                ", document=" + document +
                ", number='" + number + '\'' +
                ", date=" + date +
                '}';
    }
}
