package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.AnalysisService;

@RestController
@RequestMapping("/api/analyze")
@CrossOrigin
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @PostMapping
    public Map<String, Object> analyze(
            @RequestParam("role") String role,
            @RequestBody List<String> userSkills) {

        return analysisService.analyze(role, userSkills);
    }
}