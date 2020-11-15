package com.example.stacklyapichallenge1.repository;

import com.example.stacklyapichallenge1.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByEmail(String email);
}
