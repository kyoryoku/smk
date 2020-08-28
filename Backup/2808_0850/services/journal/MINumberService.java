package lab.smk.services.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MINumberService {

    @Autowired
    MINumberRepository miNumberRepository;

    public Iterable<MINumber> findAll() {
        return miNumberRepository.findAll();
    }
}
