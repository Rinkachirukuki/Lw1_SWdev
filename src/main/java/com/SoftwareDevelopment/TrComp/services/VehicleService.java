package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Vehicle;
import com.SoftwareDevelopment.TrComp.repositories.VehicleRepository;
import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle findById(Integer id) {
        Optional<Vehicle> result = vehicleRepository.findById(id);
        Vehicle n = null;
        if(result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }
    public Iterable<Vehicle> findAll(Pageable pageable){
        return vehicleRepository.findAll(pageable);
    }
    public Iterable<Vehicle> findAll(Sort sort){
        return vehicleRepository.findAll(sort);

    }

    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public void deleteById(Integer id){
        vehicleRepository.deleteById(id);
    }




}
