package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.SkillDto;
import com.hualpusher.portfolio.dto.SkillGroupDto;
import com.hualpusher.portfolio.entity.Skill;
import com.hualpusher.portfolio.entity.SkillGroup;
import com.hualpusher.portfolio.repository.SkillGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class SkillGroupServiceImpl extends BaseServiceImpl<SkillGroup, Long> {

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
        return modelMapper.map(skillGroup, SkillGroupDto.class);
    }

    public SkillGroup convertToEntity(SkillGroupDto skillGroupDto) {
        SkillGroup skillGroup = modelMapper.map(skillGroupDto, SkillGroup.class);
        if (skillGroupDto.getItems() != null) {
            skillGroup.setItems(skillGroupDto.getItems().stream()
                    .map(skillDto -> modelMapper.map(skillDto, Skill.class))
                    .collect(Collectors.toList()));
        }
        return skillGroup;
    }
}

