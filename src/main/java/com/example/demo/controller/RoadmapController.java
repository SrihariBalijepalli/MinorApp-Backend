package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.RoadmapService;

@RestController
@RequestMapping("/api/roadmap")
@CrossOrigin
public class RoadmapController {

    @Autowired
    private RoadmapService roadmapService;

    @PostMapping
    public Map<String, List<String>> generateRoadmap(
            @RequestBody List<String> missingSkills) {

        return roadmapService.generateRoadmap(missingSkills);
    }
}