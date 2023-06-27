package com.yessenali.fleetapp.controllers;

import com.yessenali.fleetapp.models.*;
import com.yessenali.fleetapp.services.ClientService;
import com.yessenali.fleetapp.services.CountryService;
import com.yessenali.fleetapp.services.InvoiceService;
import com.yessenali.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @GetMapping("/invoices")
    public String getInvoices(Model model){
        List<Invoice> invoiceList = invoiceService.getInvoices();
        model.addAttribute("invoices", invoiceList);
        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses", invoiceStatusList);
        return "Invoice";
    }

    @PostMapping("/invoices/new")
    public String addNew(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("/invoices/findById/")
    @ResponseBody
    public Optional<Invoice> findById(int id){
        return invoiceService.findById(id);
    }

    @RequestMapping(value = "/invoices/update",  method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete",  method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
