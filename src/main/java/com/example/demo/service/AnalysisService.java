package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;

@Service
public class AnalysisService {

    @Autowired
    private SkillGapService skillGapService;

    @Autowired
    private RoadmapService roadmapService;

    public Map<String, Object> analyze(String role, List<String> userSkills) {

        // 🔴 VALIDATION
        if (role == null || role.trim().isEmpty()) {
            throw new BadRequestException("Role cannot be empty");
        }

        if (userSkills == null || userSkills.isEmpty()) {
            throw new BadRequestException("User skills cannot be empty");
        }

        // Step 1: Skill Gap
        Map<String, Object> gapResult =
                skillGapService.analyzeSkillGap(role, userSkills);

        List<String> missingSkills =
                (List<String>) gapResult.get("missingSkills");

        // Step 2: Roadmap
        Map<String, List<String>> roadmap =
                roadmapService.generateRoadmap(missingSkills);

        // Combine results
        Map<String, Object> finalResult = new HashMap<>();
        finalResult.putAll(gapResult);
        finalResult.put("roadmap", roadmap);

        return finalResult;
    }
}