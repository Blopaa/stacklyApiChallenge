package com.example.stacklyapichallenge1.services;

import com.example.stacklyapichallenge1.entities.Employee;
import com.example.stacklyapichallenge1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;;import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String AddSkillToUser(int skillId, int employeeId){
        employeeRepository.AddSkillToUser(employeeId, skillId);
        return "Skill Added To User";
    }

    public List<Employee> getAllEmployees(){
       return (List<Employee>) employeeRepository.findAll();
    }

}
