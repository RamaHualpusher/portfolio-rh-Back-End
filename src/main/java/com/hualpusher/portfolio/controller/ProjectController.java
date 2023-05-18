package com.hualpusher.portfolio.controller;

import com.hualpusher.portfolio.dto.ProjectDto;
import com.hualpusher.portfolio.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "https://portfolio-ramiro-hualpa.web.app")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.findAll().stream()
                .map(projectService::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long id) {
        return projectService.findById(id)
                .map(projectService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProjectDto createProject(@RequestBody ProjectDto projectDto) {
        return projectService.convertToDto(projectService.save(projectService.convertToEntity(projectDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto) {
        return projectService.findById(id)
                .map(project -> {
                    project = projectService.convertToEntity(projectDto);
                    return projectService.save(project);
                })
                .map(projectService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        return projectService.findById(id)
                .map(project -> {
                    projectService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
