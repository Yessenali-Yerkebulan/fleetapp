package com.yessenali.fleetapp.services;

import com.yessenali.fleetapp.models.Employee;
import com.yessenali.fleetapp.models.Employee;
import com.yessenali.fleetapp.repositories.EmployeeRepository;
import com.yessenali.fleetapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //return list of employees;
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    //save new employee
    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    //get employee by id
    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee findByUsername(String un) {
        return employeeRepository.findByUsername(un);
    }
}
