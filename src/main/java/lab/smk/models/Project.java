package lab.smk.models;

import lab.smk.models.journals.TestSample;
import lab.smk.models.system.Employee;

import javax.persistence.*;

@Entity
@Table(name = "lab_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(optional = false, mappedBy = "project")
    private TestSample testSample;
    private String status;

    @OneToOne
    @JoinColumn(name = "contract_id", unique = true, nullable = false, updatable = false)
    private Contract contract;

    public Project() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestSample getTestSample() {
        return testSample;
    }

    public void setTestSample(TestSample testSample) {
        this.testSample = testSample;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
