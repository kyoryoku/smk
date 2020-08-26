package lab.smk.repo;

import lab.smk.models.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Long> {
}
