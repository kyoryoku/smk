package lab.smk.models.journals;

import lab.smk.models.Project;
import lab.smk.models.system.Employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lab_testsample")
public class TestSample {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    private LocalDate entryDate;
    private LocalDate returnDate;

    public TestSample() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "TestSample{" +
                "id=" + id +
                ", project=" + project +
                ", entryDate=" + entryDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
