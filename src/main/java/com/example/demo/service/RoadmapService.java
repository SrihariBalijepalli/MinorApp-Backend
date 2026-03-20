package com.example.demo.service;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class RoadmapService {

    // Skill → Learning Steps
    private static final Map<String, List<String>> roadmapMap = new HashMap<>();

    static {

        roadmapMap.put("Spring Boot", Arrays.asList(
                "Learn Spring Core",
                "Understand Spring Boot basics",
                "Build REST APIs",
                "Connect with database (JPA)",
                "Create mini project"));

        roadmapMap.put("Hibernate", Arrays.asList(
                "Learn ORM concepts",
                "Understand Hibernate mappings",
                "CRUD operations",
                "Integration with Spring"));

        roadmapMap.put("REST API", Arrays.asList(
                "Understand HTTP methods",
                "Build REST endpoints",
                "Use Postman",
                "Handle JSON data"));

        roadmapMap.put("React", Arrays.asList(
                "Learn JavaScript basics",
                "Understand React components",
                "State & Props",
                "Build small apps"));

        roadmapMap.put("Node.js", Arrays.asList(
                "Learn Node basics",
                "Understand Express",
                "Build APIs",
                "Connect to database"));

        roadmapMap.put("SQL", Arrays.asList(
                "Learn basic queries",
                "Joins & normalization",
                "Practice problems"));

        roadmapMap.put("Python", Arrays.asList(
                "Basics of Python",
                "Libraries (Pandas, NumPy)",
                "Mini projects"));
    }

    public Map<String, List<String>> generateRoadmap(List<String> missingSkills) {

        Map<String, List<String>> roadmap = new HashMap<>();

        for (String skill : missingSkills) {

            if (roadmapMap.containsKey(skill)) {
                roadmap.put(skill, roadmapMap.get(skill));
            } else {
                roadmap.put(skill, Arrays.asList(
                        "Learn basics of " + skill,
                        "Practice projects",
                        "Apply in real scenarios"));
            }
        }

        return roadmap;
    }
}