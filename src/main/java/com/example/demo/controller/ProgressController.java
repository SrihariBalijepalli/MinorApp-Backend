package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Progress;
import com.example.demo.service.ProgressService;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping
    public Progress saveProgress(@RequestBody Progress progress) {
        return progressService.saveProgress(progress);
    }

    @GetMapping
    public List<Progress> getProgress() {
        return progressService.getProgress();
    }
}