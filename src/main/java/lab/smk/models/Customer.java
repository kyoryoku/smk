package lab.smk.models;

import lab.smk.models.system.Employee;

import javax.persistence.*;

@Entity
@Table(name = "lab_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, mappedBy = "customer")
    private Contract contract;

    private String name;
    private String address;
    private String comment;
    private Employee employee;

    public Customer() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getComment() {
        return comment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                ", employee=" + employee +
                '}';
    }
}
