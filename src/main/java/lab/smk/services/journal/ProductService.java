package lab.smk.services.journal;

import lab.smk.models.Product;
import lab.smk.models.system.Account;
import lab.smk.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
