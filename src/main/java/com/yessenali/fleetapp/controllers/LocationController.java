package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.Country;
import com.yessenali.fleetapp.models.Location;
import com.yessenali.fleetapp.models.State;
import com.yessenali.fleetapp.services.CountryService;
import com.yessenali.fleetapp.services.LocationService;
import com.yessenali.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private LocationService locationService;
    @GetMapping("/locations")
    public String getLocations(Model model){
        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);
        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "Location";
    }
    @PostMapping("/locations/new")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }
    @RequestMapping("/locations/findById/")
    @ResponseBody
    public Optional<Location> findByID(int id){
        return locationService.findById(id);
    }
    @RequestMapping(value="/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value="/locations/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        locationService.delete(id);
        return "redirect:/locations";
    }
}
