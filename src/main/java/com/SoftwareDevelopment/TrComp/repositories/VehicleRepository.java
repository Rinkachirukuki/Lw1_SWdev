package com.SoftwareDevelopment.TrComp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.SoftwareDevelopment.TrComp.models.Vehicle;

public interface VehicleRepository extends
CrudRepository<Vehicle, Integer> { }
