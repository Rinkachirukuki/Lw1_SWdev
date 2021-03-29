package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Customer;
import com.SoftwareDevelopment.TrComp.models.Vehicle;
import com.SoftwareDevelopment.TrComp.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public Customer findById(Integer id){
        Optional<Customer> result = customerRepository.findById(id);
        Customer n = null;
        if(result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }
}
