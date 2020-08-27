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
    private Task task;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="miNumber_id")
    private MINumber miNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="piNumber_id")
    private PINumber piNumber;

    public Document() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public MINumber getMiNumber() {
        return miNumber;
    }

    public void setMiNumber(MINumber miNumber) {
        this.miNumber = miNumber;
    }

    public PINumber getPiNumber() {
        return piNumber;
    }

    public void setPiNumber(PINumber piNumber) {
        this.piNumber = piNumber;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", task=" + task +
                ", miNumber=" + miNumber +
                ", piNumber=" + piNumber +
                '}';
    }
}
