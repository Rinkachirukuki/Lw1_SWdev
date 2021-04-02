package com.SoftwareDevelopment.TrComp.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.SoftwareDevelopment.TrComp.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
/*
    @EntityGraph(attributePaths = {"tags"})
    public Iterable<Vehicle> findAllLazy();

 */
}
