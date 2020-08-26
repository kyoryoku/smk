package lab.smk.models;

import lab.smk.models.system.Employee;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lab_contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, mappedBy = "contract")
    private Project project;

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true, nullable = false, updatable = false)
    private Customer customer;

    private String number;
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contract")
    private Set<Task> tasks;

    private String status;
    private Employee employee;

    public Contract() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Iterable<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Iterable<Task> tasks) {
        this.tasks = tasks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", customer=" + customer +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", tasks=" + tasks +
                ", status='" + status + '\'' +
                ", employee=" + employee +
                '}';
    }
}
