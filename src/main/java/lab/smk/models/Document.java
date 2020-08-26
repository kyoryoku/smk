package lab.smk.models;

import lab.smk.models.journals.MINumber;
import lab.smk.models.journals.PINumber;

import javax.persistence.*;

@Entity
@Table(name = "lab_document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(optional = false, mappedBy = "document")
    private Document document;

    @OneToOne(optional = false)
    @JoinColumn(name="miNumber_id", unique = true, nullable = false, updatable = false)
    private MINumber miNumber;

    @OneToOne(optional = false)
    @JoinColumn(name="piNumber_id", unique = true, nullable = false, updatable = false)
    private PINumber piNumber;

    public Document() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public MINumber getMiNumber() {
        return miNumber;
    }

    public PINumber getPiNumber() {
        return piNumber;
    }

    public void setMiNumber(MINumber miNumber) {
        this.miNumber = miNumber;
    }

    public void setPiNumber(PINumber piNumber) {
        this.piNumber = piNumber;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", miNumber=" + miNumber +
                ", piNumber=" + piNumber +
                '}';
    }
}
