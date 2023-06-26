package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.VehicleMake;
import com.yessenali.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @GetMapping("/vehicleMakes")
    public String getVehicleMakes(Model model){
        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakeList);
        return "VehicleMake";
    }
    @PostMapping("/vehicleMakes/new")
    public String addNew(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }
    @RequestMapping("/vehicleMakes/findById/")
    @ResponseBody
    public Optional<VehicleMake> findByID(int id){
        return vehicleMakeService.findById(id);
    }
    @RequestMapping(value="/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value="/vehicleMakes/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMakes";
    }
}
