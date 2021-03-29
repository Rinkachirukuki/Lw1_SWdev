package com.SoftwareDevelopment.TrComp.controllers;

import com.SoftwareDevelopment.TrComp.models.Customer;
import com.SoftwareDevelopment.TrComp.models.Order;
import com.SoftwareDevelopment.TrComp.models.Vehicle;
import com.SoftwareDevelopment.TrComp.repositories.CustomerRepository;
import com.SoftwareDevelopment.TrComp.repositories.OrderRepository;
import com.SoftwareDevelopment.TrComp.repositories.VehicleRepository;
import com.SoftwareDevelopment.TrComp.services.CustomerService;
import com.SoftwareDevelopment.TrComp.services.OrderService;
import com.SoftwareDevelopment.TrComp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping
public class MainController {
    @Autowired
    private VehicleRepository vehicleService;
    @Autowired
    private CustomerRepository customerService;
    @Autowired
    private OrderRepository orderService;

    @PostMapping(path= "/add")
    public @ResponseBody String addNewVehicle(@RequestParam String number, @RequestParam String model, @RequestParam String mark,@RequestParam Integer garageId) {

        Order n = new Order();
        n.setId(1);
        n.setVehicle(vehicleService.findById(1).get());
        n.setCustomer(customerService.findById(1).get());
        n.setDestinationPoint("dest point");
        n.setStartPoint("start point");
        n.setPrice(100);
        orderService.save(n);
        return "Saved";
    }

    /*
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Vehicle> getAllVehicles(){
        return  vehicleService.findAll();
    }

     */
}



/*
@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("title","Главная страница");
        return "index.html";
    }

}
*/
