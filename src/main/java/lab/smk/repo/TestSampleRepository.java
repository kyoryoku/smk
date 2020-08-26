package lab.smk.repo;

import lab.smk.models.journals.TestSample;
import org.springframework.data.repository.CrudRepository;

public interface TestSampleRepository extends CrudRepository<TestSample, Long> {
}
