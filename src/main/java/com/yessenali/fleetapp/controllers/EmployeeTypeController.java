package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.EmployeeType;
import com.yessenali.fleetapp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;
    @GetMapping("/employeeTypes")
    public String getEmployeeTypes(Model model){
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypeList);
        return "EmployeeType";
    }
    @PostMapping("/employeeTypes/new")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }
    @RequestMapping("/employeeTypes/findById/")
    @ResponseBody
    public Optional<EmployeeType> findByID(int id){
        return employeeTypeService.findById(id);
    }
    @RequestMapping(value="/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value="/employeeTypes/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }
}
