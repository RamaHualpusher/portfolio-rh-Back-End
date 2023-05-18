package com.hualpusher.portfolio.controller;

import com.hualpusher.portfolio.dto.SkillGroupDto;
import com.hualpusher.portfolio.service.SkillGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skillgroup")
@CrossOrigin(origins = "https://portfolio-ramiro-hualpa.web.app")
public class SkillGroupController {

    private final SkillGroupServiceImpl skillGroupService;

    @Autowired
    public SkillGroupController(SkillGroupServiceImpl skillGroupService) {
        this.skillGroupService = skillGroupService;
    }

    @GetMapping
    public List<SkillGroupDto> getAllSkillGroups() {
        return skillGroupService.findAll().stream()
                .map(skillGroupService::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillGroupDto> getSkillGroupById(@PathVariable Long id) {
        return skillGroupService.findById(id)
                .map(skillGroupService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SkillGroupDto createSkillGroup(@RequestBody SkillGroupDto skillGroupDto) {
        return skillGroupService.convertToDto(skillGroupService.save(skillGroupService.convertToEntity(skillGroupDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillGroupDto> updateSkillGroup(@PathVariable Long id, @RequestBody SkillGroupDto skillGroupDto) {
        return skillGroupService.findById(id)
                .map(skillGroup -> {
                    skillGroup = skillGroupService.convertToEntity(skillGroupDto);
                    return skillGroupService.save(skillGroup);
                })
                .map(skillGroupService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkillGroup(@PathVariable Long id) {
        return skillGroupService.findById(id)
                .map(skillGroup -> {
                    skillGroupService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
