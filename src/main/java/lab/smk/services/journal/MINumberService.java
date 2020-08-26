package lab.smk.services.journal;

import lab.smk.repo.MINumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MINumberService {

    @Autowired
    MINumberRepository miNumberRepository;

}
