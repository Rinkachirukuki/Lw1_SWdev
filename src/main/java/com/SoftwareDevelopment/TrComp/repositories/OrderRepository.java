package com.SoftwareDevelopment.TrComp.repositories;

import com.SoftwareDevelopment.TrComp.models.TaxiOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends
        JpaRepository<TaxiOrder, Integer> { };
