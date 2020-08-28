package lab.smk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    public Iterable<Document> findAll() {
        return documentRepository.findAll();
    }
}
