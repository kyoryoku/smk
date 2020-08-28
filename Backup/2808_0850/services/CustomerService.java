package lab.smk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
}
