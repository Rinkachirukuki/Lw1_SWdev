package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Driver;
import com.SoftwareDevelopment.TrComp.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;

    public Driver findById(Integer id) {
        Optional<Driver> result = driverRepository.findById(id);
        Driver n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Driver> findAll() {
        return driverRepository.findAll();
    }

    public Iterable<Driver> findAll(Pageable pageable) {
        return driverRepository.findAll(pageable);
    }

    public Iterable<Driver> findAll(Sort sort) {
        return driverRepository.findAll(sort);

    }

    public void save(Driver driver) {
        driverRepository.save(driver);
    }

    public void deleteById(Integer id){
        driverRepository.deleteById(id);
    }
}

