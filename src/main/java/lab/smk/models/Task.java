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
    private Employee employee;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    public Task() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public Product getProduct() {
        return product;
    }

    public Document getDocument() {
        return document;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", product=" + product +
                ", document=" + document +
                ", employee=" + employee +
                '}';
    }
}
