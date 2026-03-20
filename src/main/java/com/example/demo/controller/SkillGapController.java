package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.SkillGapService;

@RestController
@RequestMapping("/api/skill-gap")
@CrossOrigin
public class SkillGapController {

    @Autowired
    private SkillGapService skillGapService;

    @PostMapping
    public Map<String, Object> analyzeGap(
            @RequestParam String role,
            @RequestBody List<String> userSkills) {

        return skillGapService.analyzeSkillGap(role, userSkills);
    }
}