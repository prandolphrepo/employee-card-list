package com.employee.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.models.Employee;
import com.employee.employee.repo.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Optional<List<Employee>> getAllEmployees(){
        return employeeRepo.findAllById();
    }
}
