package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Customer;
import com.SoftwareDevelopment.TrComp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public Customer findById(Integer id) {
        Optional<Customer> result = customerRepository.findById(id);
        Customer n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Iterable<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public Iterable<Customer> findAll(Sort sort) {
        return customerRepository.findAll(sort);

    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteById(Integer id){
        customerRepository.deleteById(id);
    }
}

