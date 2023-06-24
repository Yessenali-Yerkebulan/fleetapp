package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.State;
import com.yessenali.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    //return list of states;
    public List<State> getStates(){
        return stateRepository.findAll();
    }

    //save new state
    public void save(State country){
        stateRepository.save(country);
    }

    //get country by id
    public Optional<State> findById(int id){
        return stateRepository.findById(id);
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
