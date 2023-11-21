package com.employee.employee.controller;

import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    public String employeeSubmit(@ModelAttribute Employees employee,
    @RequestParam("image")MultipartFile multipartFile, Model model) throws IOException{
      try{
      if(employee.getCompanyName().isBlank() || employee.getFirstName().isBlank() || employee.getLastName().isBlank()
      || employee.getRole().isBlank() || employee.getAge() == 0){
        
        throw new EmployeeAddException("Error: Employee can not be added, null value");
      }
    } catch (EmployeeAddException e){
      model.addAttribute("errorMessage", e.getMessage());
      return "error";

    }
  
      String image = employeeService.uploadFile(multipartFile);
      employee.setImage(image);
      employeeService.addEmployee(employee);
      model.addAttribute("image", image);
      return "redirect:/";
    }

    
}
