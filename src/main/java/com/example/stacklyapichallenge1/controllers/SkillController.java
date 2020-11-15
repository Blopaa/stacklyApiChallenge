package com.example.stacklyapichallenge1.controllers;

import com.example.stacklyapichallenge1.entities.Skill;
import com.example.stacklyapichallenge1.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("register")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill){
        return new ResponseEntity<>(skillService.createSkill(skill), HttpStatus.CREATED);
    }

}
