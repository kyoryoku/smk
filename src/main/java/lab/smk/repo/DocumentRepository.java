package lab.smk.repo;

import lab.smk.models.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
