package lab.smk.services.journal;

import lab.smk.models.journals.MINumber;
import lab.smk.models.journals.PINumber;
import lab.smk.repo.PINumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PINumberService {
    @Autowired
    PINumberRepository piNumberRepository;

    public Iterable<PINumber> findAll() {
        return piNumberRepository.findAll();
    }
}
