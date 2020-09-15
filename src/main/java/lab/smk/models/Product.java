package lab.smk.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "lab_product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private LocalDate arrivalDate;
    private LocalDate returnDate;
    private String name;
    private String serialNumber;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public void addContract(Contract contract){
        contract.getProducts().add(this);
        this.contract = contract;
    }

    public void addTask(Task task){
        task.setProduct(this);
        this.tasks.add(task);
    }

}
