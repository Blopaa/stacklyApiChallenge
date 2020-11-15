package com.example.stacklyapichallenge1.services;

import com.example.stacklyapichallenge1.entities.Skill;
import com.example.stacklyapichallenge1.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public Skill createSkill(Skill skill){
        skillRepository.save(skill);
        return skill;
    }
}
