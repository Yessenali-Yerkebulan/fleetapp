package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.Contact;
import com.yessenali.fleetapp.models.State;
import com.yessenali.fleetapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    //return list of contacts;
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    //save new contact
    public void save(Contact contact){
        contactRepository.save(contact);
    }

    //get contact by id
    public Optional<Contact> findById(int id){
        return contactRepository.findById(id);
    }

    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }
}