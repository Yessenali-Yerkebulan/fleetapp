package com.yessenali.fleetapp.security.services;

import com.yessenali.fleetapp.models.User;
import com.yessenali.fleetapp.repositories.UserRepository;
import com.yessenali.fleetapp.security.models.Role;
import com.yessenali.fleetapp.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    //return list of Roles;
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    //save new Role
    public void save(Role Role){
        roleRepository.save(Role);
    }

    //get Role by id
    public Optional<Role> findById(int id){
        return roleRepository.findById(id);
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public void assignUserRole(Integer userId, Integer roleId){
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    public void unassignRole(Integer userId, Integer roleId){
        User user = userRepository.findById(userId).orElse(null);
        Set<Role> userRoles = user.getRoles();
        userRoles.removeIf(x -> x.getId() == roleId);
        userRepository.save(user);
    }

    public Set<Role> getUserRoles(User user){
        return user.getRoles();
    }

    public Set<Role> getUserNotRoles(User user){
        return roleRepository.getUserNotRoles(user.getId());
    }
}
