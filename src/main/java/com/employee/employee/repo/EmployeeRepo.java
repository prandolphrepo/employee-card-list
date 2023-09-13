package com.employee.employee.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee.models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<List<Employee>> findAllById();
    
}
