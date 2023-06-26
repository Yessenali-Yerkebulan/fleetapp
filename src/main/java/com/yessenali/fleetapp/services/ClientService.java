package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.Client;
import com.yessenali.fleetapp.models.State;
import com.yessenali.fleetapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    //return list of states;
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    //save new state
    public void save(Client client){
        clientRepository.save(client);
    }

    //get country by id
    public Optional<Client> findById(int id){
        return clientRepository.findById(id);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
