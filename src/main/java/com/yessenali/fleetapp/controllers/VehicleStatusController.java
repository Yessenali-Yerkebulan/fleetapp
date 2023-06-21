package com.yessenali.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleStatusController {
    @GetMapping("/vehiclestatuses")
    public String getVehicleStatuses(){
        return "VehicleStatus";
    }
}
