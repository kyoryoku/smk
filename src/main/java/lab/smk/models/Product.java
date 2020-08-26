package lab.smk.models;

import lab.smk.models.system.Employee;

import javax.persistence.*;

@Entity
@Table(name = "lab_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, mappedBy = "product")
    private Task task;
    private String name;
    private String serialNumber;
    private Employee employee;

    public void setId(Long id) {
        this.id = id;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", employee=" + employee +
                '}';
    }
}
