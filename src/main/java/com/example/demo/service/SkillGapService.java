package com.example.demo.service;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class SkillGapService {

    private static final Map<String, List<String>> roleSkills = new HashMap<>();

    static {
        roleSkills.put("Java Developer", Arrays.asList(
                "Java", "Spring Boot", "Hibernate", "MySQL", "REST API"));

        roleSkills.put("Web Developer", Arrays.asList(
                "HTML", "CSS", "JavaScript", "React", "Node.js"));

        roleSkills.put("Data Analyst", Arrays.asList(
                "Python", "SQL", "Excel", "Power BI", "Statistics"));

        roleSkills.put("Full Stack Developer", Arrays.asList(
                "HTML", "CSS", "JavaScript", "React", "Node.js", "Express", "MongoDB"));

        roleSkills.put("Frontend Developer", Arrays.asList(
                "HTML", "CSS", "JavaScript", "React", "Redux", "Tailwind CSS"));

        roleSkills.put("Backend Developer", Arrays.asList(
                "Java", "Spring Boot", "REST API", "Microservices", "SQL", "Docker"));

        roleSkills.put("Mobile Developer", Arrays.asList(
                "Java", "Kotlin", "Swift", "React Native", "Flutter", "Firebase"));

        roleSkills.put("DevOps Engineer", Arrays.asList(
                "Linux", "Git", "Docker", "Kubernetes", "AWS", "CI/CD"));
    }

    public Map<String, Object> analyzeSkillGap(String role, List<String> userSkills) {

        List<String> required = roleSkills.getOrDefault(role, new ArrayList<>());

        List<String> missing = new ArrayList<>();

        for (String skill : required) {
            if (!userSkills.contains(skill)) {
                missing.add(skill);
            }
        }

        int total = required.size();
        double gapPercentage = total == 0 ? 0 :
                ((double) missing.size() / total) * 100;

        Map<String, Object> result = new HashMap<>();
        result.put("requiredSkills", required);
        result.put("userSkills", userSkills);
        result.put("missingSkills", missing);
        result.put("gapPercentage", gapPercentage);

        return result;
    }
}