package com.hualpusher.portfolio.controller;

import com.hualpusher.portfolio.dto.SocialDto;
import com.hualpusher.portfolio.service.SocialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/social")
@CrossOrigin(origins = "https://portfolio-ramiro-hualpa.web.app")
public class SocialController {

    private final SocialServiceImpl socialService;

    @Autowired
    public SocialController(SocialServiceImpl socialService) {
        this.socialService = socialService;
    }

    @GetMapping
    public List<SocialDto> getAllSocials() {
        return socialService.findAll().stream()
                .map(socialService::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialDto> getSocialById(@PathVariable Long id) {
        return socialService.findById(id)
                .map(socialService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SocialDto createSocial(@RequestBody SocialDto socialDto) {
        return socialService.convertToDto(socialService.save(socialService.convertToEntity(socialDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocialDto> updateSocial(@PathVariable Long id, @RequestBody SocialDto socialDto) {
        return socialService.findById(id)
                .map(social -> {
                    social = socialService.convertToEntity(socialDto);
                    return socialService.save(social);
                })
                .map(socialService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocial(@PathVariable Long id) {
        return socialService.findById(id)
                .map(social -> {
                    socialService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
