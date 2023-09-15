package com.employee.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.employee.models.Employees;
import com.employee.employee.service.EmployeeService;

@Controller
public class FormController {

    @Autowired 
    EmployeeService employeeService;
  
    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("employees", new Employees());
        return "index";
    }
    
    @PostMapping("/employee")
    public String employeeSubmit(@ModelAttribute Employees employee){
      if(employeeService.addEmployee(employee) == null){
        return error();
      }
      return employeeService.addEmployee(employee);
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
