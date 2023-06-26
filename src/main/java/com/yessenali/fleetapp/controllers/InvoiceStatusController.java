package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.InvoiceStatus;
import com.yessenali.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @GetMapping("/invoiceStatuses")
    public String getInvoiceStatuses(Model model){
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses", invoiceStatusList);
        return "InvoiceStatus";
    }
    @PostMapping("/invoiceStatuses/new")
    public String addNew(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }
    @RequestMapping("/invoiceStatuses/findById/")
    @ResponseBody
    public Optional<InvoiceStatus> findByID(int id){
        return invoiceStatusService.findById(id);
    }
    @RequestMapping(value="/invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value="/invoiceStatuses/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatuses";
    }
}
