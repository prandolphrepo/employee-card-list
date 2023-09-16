package com.employee.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee.models.Employees;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Long> {

    List<Employees> findAll();
    
}
