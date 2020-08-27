package lab.smk.services;

import lab.smk.models.Document;
import lab.smk.repo.DocumentRepository;
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
