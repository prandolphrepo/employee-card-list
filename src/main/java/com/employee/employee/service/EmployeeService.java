package com.employee.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.models.Employees;
import com.employee.employee.repo.EmployeeRepo;



@Service
public class EmployeeService {

    
    @Autowired
    EmployeeRepo employeeRepo;


    public List<Employees> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public String addEmployee(Employees employee){
        
        if(!(employee.getCompanyName().isBlank() || employee.getFirstName().isBlank() || employee.getLastName().isBlank()
        || employee.getRole().isBlank() || employee.getAge() == 0)){

            employeeRepo.save(employee);
            return "redirect:/";
        }
        return null;
    }


}
