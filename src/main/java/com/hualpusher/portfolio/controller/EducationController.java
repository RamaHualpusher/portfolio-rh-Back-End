package com.hualpusher.portfolio.controller;

import com.hualpusher.portfolio.dto.EducationDto;
import com.hualpusher.portfolio.entity.Education;
import com.hualpusher.portfolio.service.EducationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/education")
@CrossOrigin(origins = "https://portfolio-ramiro-hualpa.web.app")
public class EducationController {

    private final EducationServiceImpl educationService;

    @Autowired
    public EducationController(EducationServiceImpl educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto educationDto) {
        Education education = educationService.convertToEntity(educationDto);
        Education createdEducation = educationService.save(education);
        return ResponseEntity.ok(educationService.convertToDto(createdEducation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationDto> getEducation(@PathVariable Long id) {
        return educationService.findById(id)
                .map(educationService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EducationDto>> getAllEducation() {
        List<EducationDto> educationDtos = educationService.findAll().stream()
                .map(educationService::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(educationDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationDto> updateEducation(@PathVariable Long id, @RequestBody EducationDto educationDto) {
        return educationService.findById(id)
                .map(education -> {
                    education.setInstitution(educationDto.getInstitution());
                    education.setDegree(educationDto.getDegree());
                    education.setStartDate(educationDto.getStartDate());
                    education.setEndDate(educationDto.getEndDate());
                    education.setDescription(educationDto.getDescription());
                    return educationService.save(education);
                })
                .map(educationService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
