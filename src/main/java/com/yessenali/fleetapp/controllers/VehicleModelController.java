package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.VehicleModel;
import com.yessenali.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;
    @GetMapping("/vehicleModels")
    public String getVehicleModels(Model model){
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels", vehicleModelList);
        return "VehicleModel";
    }
    @PostMapping("/vehicleModels/new")
    public String addNew(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }
    @RequestMapping("/vehicleModels/findById/")
    @ResponseBody
    public Optional<VehicleModel> findByID(int id){
        return vehicleModelService.findById(id);
    }
    @RequestMapping(value="/vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value="/vehicleModels/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleModelService.delete(id);
        return "redirect:/vehicleModels";
    }
}
