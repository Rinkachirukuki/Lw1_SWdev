package com.SoftwareDevelopment.TrComp.controllers;

import com.SoftwareDevelopment.TrComp.models.Driver;
import com.SoftwareDevelopment.TrComp.models.Gender;
import com.SoftwareDevelopment.TrComp.models.Vehicle;
import com.SoftwareDevelopment.TrComp.services.DriverService;
import com.SoftwareDevelopment.TrComp.services.GenderService;
import com.SoftwareDevelopment.TrComp.services.MarkService;
import com.SoftwareDevelopment.TrComp.services.VehicleService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/driver")
public class DriverController {

    public DriverController(VehicleService vehicleService, GenderService genderService, DriverService driverService) {
        this.vehicleService = vehicleService;
        this.genderService = genderService;
        this.driverService = driverService;
    }

    private VehicleService vehicleService;
    private GenderService genderService;
    private DriverService driverService;

    @GetMapping("/list")
    public String showAllDrivers(Pageable page, Model model){

        model.addAttribute("drivers", driverService.findAll(page));

        return "driver/show-all-drivers.html";
    }

    @GetMapping("/delete")
    public String driverDelete(@RequestParam("id") int id) {
        driverService.deleteById(id);

        return "redirect:/driver/list";
    }

    @GetMapping("/update")
    public String driverUpdate(@RequestParam("id") Integer id, Model model) {

        model.addAttribute("driver", driverService.findById(id));

        model.addAttribute("genderList", genderService.findAll());

        return "driver/update-form";
    }

    @GetMapping("/add")
    public String driverAdd(Model model) {

        model.addAttribute("driver", new Driver());

        model.addAttribute("genderList", genderService.findAll());

        return "driver/update-form";
    }

    @PostMapping("/save")
    public String driverSave(@ModelAttribute("vehicle") Driver driver) {
        driverService.save(driver);
        return "redirect:/driver/list";
    }




}
