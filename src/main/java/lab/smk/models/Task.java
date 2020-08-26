package lab.smk.models;

import lab.smk.models.system.Employee;

import javax.persistence.*;

@Entity
@Table(name = "lab_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String task;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id", unique = true, nullable = false, updatable = false)
    private Product product;
    @OneToOne(optional = false)
    @JoinColumn(name = "document_id", unique = true, nullable = false, updatable = false)
    private Document document;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
