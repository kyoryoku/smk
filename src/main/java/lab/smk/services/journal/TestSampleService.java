package lab.smk.services.journal;

import lab.smk.models.journals.TestSample;
import lab.smk.models.system.Account;
import lab.smk.repo.TestSampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;

@Service
public class TestSampleService {
    @Autowired
    TestSampleRepository testSampleRepository;

    public Iterable<TestSample> findAll() {
        return testSampleRepository.findAll();
    }
}