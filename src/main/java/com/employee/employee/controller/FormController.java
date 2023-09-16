package com.employee.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.employee.EmployeeAddException;
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

    @GetMapping("/result")
    public String getResult(){
      return "result";
    }
    
    @GetMapping("/employee-result")
    public @ResponseBody List<Employees> employeeResult(){
     return employeeService.getAllEmployees();
    }
    
    @PostMapping("/employee")
    public String employeeSubmit(@ModelAttribute Employees employee){
      try{
      if(employeeService.addEmployee(employee) == null){
        throw new EmployeeAddException("Error: Employee can not be added");
      }
    } catch (EmployeeAddException e){
      
      return "error";

    }
      return employeeService.addEmployee(employee);
    }

    
}
