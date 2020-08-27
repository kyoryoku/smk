package lab.smk.services.journal;

import lab.smk.models.journals.MINumber;
import lab.smk.repo.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {
    @Autowired
    ProgramRepository programRepository;

}
