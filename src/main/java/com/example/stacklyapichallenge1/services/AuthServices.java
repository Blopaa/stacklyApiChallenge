package com.example.stacklyapichallenge1.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.stacklyapichallenge1.dto.EmployeeRequest;
import com.example.stacklyapichallenge1.entities.Employee;
import com.example.stacklyapichallenge1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    EmployeeRepository employeeRepository;

    public String SignUp(Employee employee) {
        try {
            if (employee.getEmail() == null) {
                return "You must write an email";
            } else if (employee.getPassword() == null) {
                return "You must write a password";
            } else if (employee.getName() == null) {
                return "You must write a name";
            }
            Employee savedUser =  employeeRepository.save(employee);
            Algorithm algorithm = Algorithm.HMAC256("superSecret");
            return JWT.create()
                    .withClaim("userId", savedUser.getId())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            return "Invalid Signing configuration / Couldn't convert Claims.";
        }
    }

    public String SignInUser(EmployeeRequest employee) {
        try {
            if (employee.getEmail() == null || employee.getPassword() == null) {
                return "You must write an email and a password";
            }
            Employee foundEmployee = employeeRepository.findByEmail(employee.getEmail());
            if (foundEmployee == null) {
                return null;
            }

            if (!foundEmployee.getPassword().equals(employee.getPassword())) {
                return null;
            }

            Algorithm algorithm = Algorithm.HMAC256("superSecret");
            return JWT.create()
                    .withClaim("userId", foundEmployee.getId())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            return null;
        }
    }

}
