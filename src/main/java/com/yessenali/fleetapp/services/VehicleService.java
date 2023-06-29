package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.Supplier;
import com.yessenali.fleetapp.models.Vehicle;
import com.yessenali.fleetapp.repositories.SupplierRepository;
import com.yessenali.fleetapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    //return list of suppliers;
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

}
