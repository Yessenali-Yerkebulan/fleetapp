package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.Client;
import com.yessenali.fleetapp.models.Country;
import com.yessenali.fleetapp.models.State;
import com.yessenali.fleetapp.services.ClientService;
import com.yessenali.fleetapp.services.CountryService;
import com.yessenali.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    @GetMapping("/clients")
    public String getStates(Model model){
        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);
        return "Client";
    }

    @PostMapping("/clients/new")
    public String addNew(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping("/clients/findById/")
    @ResponseBody
    public Optional<Client> findById(int id){
        return clientService.findById(id);
    }

    @RequestMapping(value = "/clients/update",  method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete",  method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        clientService.delete(id);
        return "redirect:/clients";
    }
}
