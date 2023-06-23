package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.Country;
import com.yessenali.fleetapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getCountries(Model model){
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "Country";
    }

    @PostMapping("/countries/new")
    public String addNew(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }
}
