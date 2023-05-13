package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.SkillDto;
import com.hualpusher.portfolio.dto.SkillGroupDto;
import com.hualpusher.portfolio.entity.Skill;
import com.hualpusher.portfolio.entity.SkillGroup;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.SkillGroupRepository;
import com.hualpusher.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class SkillGroupServiceImpl extends BaseServiceImpl<SkillGroup, Long> {
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public SkillGroupServiceImpl(SkillGroupRepository repository) {
        super(repository);
        this.modelMapper = new ModelMapper();

        // Personaliza el mapeo para SkillGroup
        ModelMapper localModelMapper = this.modelMapper;
        this.modelMapper.typeMap(SkillGroup.class, SkillGroupDto.class).addMappings(mapper -> {
            mapper.map(src -> {
                if (src.getItems() != null) {
                    return src.getItems().stream()
                            .map(skill -> modelMapper.map(skill, SkillDto.class))
                            .collect(Collectors.toList());
                } else {
                    return Collections.emptyList();
                }
            }, SkillGroupDto::setItems);
        });
    }

    public SkillGroupDto convertToDto(SkillGroup skillGroup) {
        SkillGroupDto skillGroupDto = modelMapper.map(skillGroup, SkillGroupDto.class);
        skillGroupDto.setUserId(skillGroup.getUser().getId()); // Asignar userId de SkillGroup a SkillGroupDto
        return skillGroupDto;
    }

    public SkillGroup convertToEntity(SkillGroupDto skillGroupDto) {
        SkillGroup skillGroup = modelMapper.map(skillGroupDto, SkillGroup.class);
        if (skillGroupDto.getUserId() != null) {
            User user = userRepository.findById(skillGroupDto.getUserId()) // Buscar el usuario por userId
                    .orElseThrow(() -> new RuntimeException("User not found with id " + skillGroupDto.getUserId())); // Lanzar excepción si el usuario no se encuentra
            skillGroup.setUser(user); // Asignar el usuario al grupo de habilidades
        }
        if (skillGroupDto.getItems() != null) {
            skillGroup.setItems(skillGroupDto.getItems().stream()
                    .map(skillDto -> modelMapper.map(skillDto, Skill.class))
                    .collect(Collectors.toList()));
        }
        return skillGroup;
    }
}


