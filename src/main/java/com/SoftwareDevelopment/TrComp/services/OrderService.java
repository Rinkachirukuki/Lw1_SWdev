package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.TaxiOrder;
import com.SoftwareDevelopment.TrComp.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public void save(TaxiOrder taxiOrder){
        orderRepository.save(taxiOrder);
    }



}
