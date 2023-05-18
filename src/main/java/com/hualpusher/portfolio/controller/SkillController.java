package com.hualpusher.portfolio.controller;

import com.hualpusher.portfolio.dto.SkillDto;
import com.hualpusher.portfolio.service.SkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skill")
@CrossOrigin(origins = "https://portfolio-ramiro-hualpa.web.app")
public class SkillController {

    private final SkillServiceImpl skillService;

    @Autowired
    public SkillController(SkillServiceImpl skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<SkillDto> getAllSkills() {
        return skillService.findAll().stream()
                .map(skillService::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDto> getSkillById(@PathVariable Long id) {
        return skillService.findById(id)
                .map(skillService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SkillDto createSkill(@RequestBody SkillDto skillDto) {
        return skillService.convertToDto(skillService.save(skillService.convertToEntity(skillDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillDto> updateSkill(@PathVariable Long id, @RequestBody SkillDto skillDto) {
        return skillService.findById(id)
                .map(skill -> {
                    skill = skillService.convertToEntity(skillDto);
                    return skillService.save(skill);
                })
                .map(skillService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        return skillService.findById(id)
                .map(skill -> {
                    skillService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
