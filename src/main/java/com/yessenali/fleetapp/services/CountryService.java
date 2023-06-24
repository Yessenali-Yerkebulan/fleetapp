package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.Country;
import com.yessenali.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //return list of countries;
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    //save new country
    public void save(Country country){
        countryRepository.save(country);
    }

    //get country by id
    public Optional<Country> findById(int id){
        return countryRepository.findById(id);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
