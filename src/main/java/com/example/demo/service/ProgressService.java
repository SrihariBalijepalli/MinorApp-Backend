package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Progress;
import com.example.demo.repository.ProgressRepository;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public List<Progress> getProgress() {
        return progressRepository.findAll();
    }
}