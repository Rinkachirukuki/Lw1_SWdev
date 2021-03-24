package com.SoftwareDevelopment.TrComp.controllers;

import com.SoftwareDevelopment.TrComp.models.Vehicle;
import com.SoftwareDevelopment.TrComp.repositories.VehicleRepository;
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
    private VehicleRepository vehicleRepository;

    @PostMapping(path= "/add")
    public @ResponseBody String addNewVehicle(@RequestParam String number, @RequestParam String model, @RequestParam String mark,@RequestParam Integer garageId) {

        Vehicle n = new Vehicle();
        n.setNumber(number);
        n.setModel(model);
        n.setMark(mark);
        if (garageId != null)
            n.setGarageId(garageId);
        vehicleRepository.save(n);
        return "Saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Vehicle> getAllVehicles(){
        return  vehicleRepository.findAll();
    }
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
