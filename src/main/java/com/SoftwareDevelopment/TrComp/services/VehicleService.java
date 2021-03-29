package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Vehicle;
import com.SoftwareDevelopment.TrComp.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    VehicleRepository vehicleRepository;

    public Vehicle findById(Integer id) {
        Optional<Vehicle> result = vehicleRepository.findById(id);
        Vehicle vehicle = null;
        if(result.isPresent()) {
            vehicle = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return vehicle;
    }


}
