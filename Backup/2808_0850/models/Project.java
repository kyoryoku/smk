package lab.smk.models;

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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id")
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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", testSample=" + testSample +
                ", status='" + status + '\'' +
                ", contract=" + contract +
                '}';
    }
}
