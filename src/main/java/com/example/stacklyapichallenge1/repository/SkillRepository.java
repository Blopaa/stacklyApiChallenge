package com.example.stacklyapichallenge1.repository;

import com.example.stacklyapichallenge1.entities.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Integer> {
    Skill findByName(String name);
}
