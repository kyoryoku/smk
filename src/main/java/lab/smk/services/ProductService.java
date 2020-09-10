package lab.smk.services;

import lab.smk.models.Product;
import lab.smk.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

}
