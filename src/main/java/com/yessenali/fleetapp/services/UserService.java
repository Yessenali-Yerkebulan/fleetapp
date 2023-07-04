package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.User;
import com.yessenali.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}
