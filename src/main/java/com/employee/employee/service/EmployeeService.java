package com.employee.employee.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.employee.employee.models.Employees;
import com.employee.employee.repo.EmployeeRepo;



@Service
public class EmployeeService {

    
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    Cloudinary cloudinary;


    public List<Employees> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public void addEmployee(Employees employee){

        employeeRepo.save(employee);
       
    }

  
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        try{
        String res = cloudinary.uploader()
                .upload(multipartFile.getBytes(), Map.of("public_id", UUID.randomUUID()))
                .get("url")
                .toString();

        System.out.println(res);

        return res;
        } catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

       return null;
    }


}
