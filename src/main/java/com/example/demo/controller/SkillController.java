package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping
    public Skill addSkill(@RequestBody Skill skill) {
        return skillService.addSkill(skill);
    }

    @GetMapping
    public List<Skill> getSkills() {
        return skillService.getSkills();
    }
}