package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.Supplier;
import com.yessenali.fleetapp.models.Country;
import com.yessenali.fleetapp.models.State;
import com.yessenali.fleetapp.services.SupplierService;
import com.yessenali.fleetapp.services.CountryService;
import com.yessenali.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    @GetMapping("/suppliers")
    public String getStates(Model model){
        List<Supplier> supplierList = supplierService.getSuppliers();
        model.addAttribute("suppliers", supplierList);
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);
        return "Supplier";
    }

    @PostMapping("/suppliers/new")
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping("/suppliers/findById/")
    @ResponseBody
    public Optional<Supplier> findById(int id){
        return supplierService.findById(id);
    }

    @RequestMapping(value = "/suppliers/update",  method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/delete",  method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
