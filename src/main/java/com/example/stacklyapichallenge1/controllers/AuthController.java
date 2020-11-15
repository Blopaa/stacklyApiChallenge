package com.example.stacklyapichallenge1.controllers;

import com.example.stacklyapichallenge1.entities.Employee;
import com.example.stacklyapichallenge1.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class AuthController {

    @Autowired
    AuthServices authServices;

    @PostMapping("/register")
    public ResponseEntity<String> SignUp(@RequestBody Employee employee){
        return new ResponseEntity<>( authServices.SignUp(employee), HttpStatus.CREATED);
    }

}
