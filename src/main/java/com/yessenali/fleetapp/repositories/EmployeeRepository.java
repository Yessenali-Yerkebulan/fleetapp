package com.yessenali.fleetapp.repositories;

import com.yessenali.fleetapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String un);
}
