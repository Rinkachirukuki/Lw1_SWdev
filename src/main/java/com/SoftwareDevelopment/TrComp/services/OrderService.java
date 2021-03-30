package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.TaxiOrder;
import com.SoftwareDevelopment.TrComp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void save(TaxiOrder taxiOrder){
        orderRepository.save(taxiOrder);
    }



}
