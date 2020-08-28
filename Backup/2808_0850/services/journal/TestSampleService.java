package lab.smk.services.journal;

import lab.smk.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.SecondaryTable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestSampleService {
    @Autowired
    TestSampleRepository testSampleRepository;

    public Iterable<TestSample> findAll() {
        return testSampleRepository.findAll();
    }

    public Optional<TestSample> findById(Long id){
        return testSampleRepository.findById(id);
    }



}
