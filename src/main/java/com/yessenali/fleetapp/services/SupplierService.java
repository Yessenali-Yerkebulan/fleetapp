package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.Supplier;
import com.yessenali.fleetapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    //return list of suppliers;
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    //save new supplier
    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    //get supplier by id
    public Optional<Supplier> findById(int id){
        return supplierRepository.findById(id);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }
}
