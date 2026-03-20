package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private int level;

    public Skill() {}

    public Long getId() { return id; }

    public String getSkillName() { return skillName; }

    public void setSkillName(String skillName) { this.skillName = skillName; }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }
}