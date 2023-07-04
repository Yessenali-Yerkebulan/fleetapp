package com.yessenali.fleetapp.security.controllers;

import com.yessenali.fleetapp.models.User;
import com.yessenali.fleetapp.security.models.Role;
import com.yessenali.fleetapp.security.services.RoleService;
import com.yessenali.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("/roles")
    public String getStates(Model model) {
        List<Role> roleList = roleService.getRoles();
        model.addAttribute("roles", roleList);
        return "Role";
    }

    @GetMapping("/security/user/Edit/{id}")
    public String editUser(@PathVariable Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "/userEdit";
    }

    @PostMapping("/roles/addNew")
    public String addNew(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping("roles/findById")
    @ResponseBody
    public Role findById(int id) {
        return roleService.findById(id);
    }

    @RequestMapping(value="/roles/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value="/roles/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        roleService.delete(id);
        return "redirect:/roles";
    }

    @RequestMapping("/security/role/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable Integer userId,
                             @PathVariable Integer roleId){
        roleService.assignRole(userId, roleId);
        return "redirect:/security/user/Edit/"+userId;
    }


    @RequestMapping("/security/role/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable Integer userId,
                               @PathVariable Integer roleId){
        roleService.unassignRole(userId, roleId);
        return "redirect:/security/user/Edit/"+userId;
    }
}
