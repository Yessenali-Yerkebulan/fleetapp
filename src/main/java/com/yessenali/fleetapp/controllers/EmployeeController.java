package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.Client;
import com.yessenali.fleetapp.models.Country;
import com.yessenali.fleetapp.models.State;
import com.yessenali.fleetapp.models.Employee;
import com.yessenali.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JobTitleService jobTitleService;
    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    @GetMapping("/employees")
    public String getStates(Model model){
        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employees", employeeList);
        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        return "Employee";
    }

    @PostMapping("/employees/new")
    public String addNew(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping("/employees/findById/")
    @ResponseBody
    public Optional<Employee> findById(int id){
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/employees/update",  method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete",  method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @RequestMapping(value="/employees/assignUsername")
    public String assignUsername(int id){
        employeeService.assignUsername(id);
        return "redirect:/employees";
    }
}
