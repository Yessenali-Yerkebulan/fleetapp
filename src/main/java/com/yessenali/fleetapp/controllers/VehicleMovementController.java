package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.VehicleMovement;
import com.yessenali.fleetapp.services.LocationService;
import com.yessenali.fleetapp.services.SupplierService;
import com.yessenali.fleetapp.services.VehicleMovementService;
import com.yessenali.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {
    @Autowired
    private VehicleMovementService vehicleMovementService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;
    @GetMapping("/vehicleMovements")
    public String getStates(Model model){
        List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
        model.addAttribute("vehicleMovements", vehicleMovementList);
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        return "VehicleMovement";
    }

    @PostMapping("/vehicleMovements/new")
    public String addNew(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping("/vehicleMovements/findById/")
    @ResponseBody
    public Optional<VehicleMovement> findById(int id){
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value = "/vehicleMovements/update",  method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/vehicleMovements/delete",  method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovements";
    }
}
