package lab.smk.services;

import lab.smk.models.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    ContractRepository contractRepository;

    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }
}
