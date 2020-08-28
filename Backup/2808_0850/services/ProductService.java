package lab.smk.services;

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
