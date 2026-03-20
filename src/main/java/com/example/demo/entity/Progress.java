package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private int completionPercentage;

    public Progress() {}

    public Long getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getCompletionPercentage() {
        return completionPercentage;
    }

    public void setCompletionPercentage(int completionPercentage) {
        this.completionPercentage = completionPercentage;
    }
}