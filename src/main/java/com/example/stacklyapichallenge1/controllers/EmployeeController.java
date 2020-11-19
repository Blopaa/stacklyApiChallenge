package com.example.stacklyapichallenge1.controllers;

import com.example.stacklyapichallenge1.entities.Employee;
import com.example.stacklyapichallenge1.entities.Skill;
import com.example.stacklyapichallenge1.security.JwtVerfyToken;
import com.example.stacklyapichallenge1.services.EmployeeService;
import com.example.stacklyapichallenge1.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/user")
public class EmployeeController {

    @Autowired
    private JwtVerfyToken jwtVerfyToken;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SkillService skillService;

    @PostMapping("/skills/{name}")
    public ResponseEntity<String> AddSkillToEmployee(@PathVariable String name, @RequestHeader String token){
        Skill skillFounded = skillService.findSkillByName(name);
        int skillId = skillFounded.getId();
        int employeeId = jwtVerfyToken.verifyToken(token);

        return new ResponseEntity<>(employeeService.AddSkillToUser(skillId, employeeId), HttpStatus.OK);

    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);
    }

}
