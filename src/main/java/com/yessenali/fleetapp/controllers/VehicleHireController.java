package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.VehicleHire;
import com.yessenali.fleetapp.services.ClientService;
import com.yessenali.fleetapp.services.LocationService;
import com.yessenali.fleetapp.services.VehicleHireService;
import com.yessenali.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {
    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private ClientService clientService;
    @GetMapping("/vehicleHires")
    public String getVehicleHires(Model model){
        List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
        model.addAttribute("vehicleHires", vehicleHireList);
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("clients", clientService.getClients());
        return "VehicleHire";
    }
    @PostMapping("/vehicleHires/new")
    public String addNew(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }
    @RequestMapping("/vehicleHires/findById/")
    @ResponseBody
    public Optional<VehicleHire> findByID(int id){
        return vehicleHireService.findById(id);
    }
    @RequestMapping(value="/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value="/vehicleHires/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }
}
