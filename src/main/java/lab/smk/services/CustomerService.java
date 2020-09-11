package lab.smk.services;

import lab.smk.models.Contract;
import lab.smk.models.Customer;
import lab.smk.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
}
