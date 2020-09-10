package lab.smk.services;

import lab.smk.models.Contract;
import lab.smk.models.Project;
import lab.smk.repo.ContractRepository;
import lab.smk.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    ContractRepository contractRepository;

    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract findById(Long id){
        return contractRepository.findById(id).get();
    }
}
