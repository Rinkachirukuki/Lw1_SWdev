package com.SoftwareDevelopment.TrComp.controllers;

import com.SoftwareDevelopment.TrComp.models.Driver;
import com.SoftwareDevelopment.TrComp.models.Mark;
import com.SoftwareDevelopment.TrComp.models.TaxiOrder;
import com.SoftwareDevelopment.TrComp.models.Vehicle;
import com.SoftwareDevelopment.TrComp.services.DriverService;
import com.SoftwareDevelopment.TrComp.services.MarkService;
import com.SoftwareDevelopment.TrComp.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    public VehicleController(VehicleService vehicleService, MarkService markService,DriverService driverService) {
        this.vehicleService = vehicleService;
        this.markService = markService;
        this.driverService = driverService;
    }

    private VehicleService vehicleService;
    private MarkService markService;
    private DriverService driverService;
/*
    @PostMapping(path= "/add")
    public @ResponseBody
    String addNewVehicle(@RequestParam String number, @RequestParam String model, @RequestParam String mark, @RequestParam Integer driverId, @RequestParam Integer garageId) {

        Mark c_mark = markService.findById(mark);
        Driver driver = driverService.findById(driverId);

        Vehicle n = new Vehicle(number,model,c_mark,driver);

        vehicleService.save(n);
        return "Saved";
    }
    */


    @GetMapping("/list")
    public String showAllVehicles(Model model){

        model.addAttribute("vehicles",vehicleService.findAll());

        return "vehicle/show-all-vehicles.html";
    }

    @GetMapping("/delete")
    public String vehicleDelete(@RequestParam("id") int id) {
        vehicleService.deleteById(id);

        return "redirect:/vehicle/list";
    }

    @GetMapping("/update")
    public String vehicleUpdate(@RequestParam("id") Integer id, Model model) {

        Vehicle vehicle = vehicleService.findById(id);

        model.addAttribute("vehicle", vehicle);

        model.addAttribute("markList", markService.findAll());

        model.addAttribute("driverList",driverService.findAll());

        return "vehicle/update-form";
    }

    @GetMapping("/add")
    public String vehicleAdd( Model model) {

        Vehicle vehicle = new Vehicle();

        model.addAttribute("vehicle", vehicle);

        model.addAttribute("markList", markService.findAll());

        model.addAttribute("driverList",driverService.findAll());

        return "vehicle/update-form";
    }

    @PostMapping("/save")
    public String vehicleSave(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicle/list";
    }




}
