package lab.smk.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "lab_contract")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<Product> products;

    public void addProject(Project project){
        project.setContract(this);
        this.project = project;
    }

    public void addCustomer(Customer customer){
        if (customer.getContracts() == null){
            ArrayList<Contract> tmp = new ArrayList<>();
            tmp.add(this);
            customer.setContracts(tmp);
        } else {
            customer.getContracts().add(this);
        }
        this.customer = customer;
    }

    public void addProduct(Product product){
        if (this.products == null){
            this.products = new ArrayList<Product>();
        }
        product.setContract(this);
        this.products.add(product);
    }

}
