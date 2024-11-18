package com.beehyv.server.controller;

import com.beehyv.server.entity.Project;
import com.beehyv.server.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/api/v1/projects")
    public List<Project> fetchAllProjects() {
        return projectService.fetchAllProjects();
    }

    @GetMapping("/api/v1/projects/{project-id}")
    public Project fetchProjectById(@PathVariable("project-id") Long projectId) {
        return projectService.fetchProjectById(projectId);
    }

}
