package lab.smk.repo;

import lab.smk.models.Contract;
import lab.smk.models.journals.Program;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Long> {

}
