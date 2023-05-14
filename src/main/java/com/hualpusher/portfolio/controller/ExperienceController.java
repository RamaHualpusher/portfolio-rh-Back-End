package com.hualpusher.portfolio.controller;

import com.hualpusher.portfolio.dto.ExperienceDto;
import com.hualpusher.portfolio.entity.Experience;
import com.hualpusher.portfolio.service.ExperienceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    private final ExperienceServiceImpl experienceService;

    @Autowired
    public ExperienceController(ExperienceServiceImpl experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping
    public ResponseEntity<ExperienceDto> createExperience(@RequestBody ExperienceDto experienceDto) {
        Experience experience = experienceService.convertToEntity(experienceDto);
        Experience createdExperience = experienceService.save(experience);
        return ResponseEntity.ok(experienceService.convertToDto(createdExperience));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceDto> getExperience(@PathVariable Long id) {
        return experienceService.findById(id)
                .map(experienceService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ExperienceDto>> getAllExperience() {
        List<ExperienceDto> experienceDtos = experienceService.findAll().stream()
                .map(experienceService::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(experienceDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceDto> updateExperience(@PathVariable Long id, @RequestBody ExperienceDto experienceDto) {
        return experienceService.findById(id)
                .map(experience -> {
                    experience.setCompany(experienceDto.getCompany());
                    experience.setPosition(experienceDto.getPosition());
                    experience.setStartDate(experienceDto.getStartDate());
                    experience.setEndDate(experienceDto.getEndDate());
                    experience.setDescription(experienceDto.getDescription());
                    return experienceService.save(experience);
                })
                .map(experienceService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        experienceService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
