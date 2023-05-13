package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.SkillDto;
import com.hualpusher.portfolio.entity.Skill;
import com.hualpusher.portfolio.entity.SkillGroup;
import com.hualpusher.portfolio.repository.SkillGroupRepository;
import com.hualpusher.portfolio.repository.SkillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl extends BaseServiceImpl<Skill, Long> {
    @Autowired
    private SkillGroupRepository skillGroupRepository;

    private final ModelMapper modelMapper;

    public SkillServiceImpl(SkillRepository repository) {
        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public SkillDto convertToDto(Skill skill) {
        SkillDto skillDto = modelMapper.map(skill, SkillDto.class);
        skillDto.setGroupId(skill.getGroup().getId()); // Asignar groupId de Skill a SkillDto
        return skillDto;
    }

    public Skill convertToEntity(SkillDto skillDto) {
        Skill skill = modelMapper.map(skillDto, Skill.class);
        if (skillDto.getGroupId() != null) {
            SkillGroup group = skillGroupRepository.findById(skillDto.getGroupId()) // Buscar el grupo por groupId
                    .orElseThrow(() -> new RuntimeException("SkillGroup not found with id " + skillDto.getGroupId())); // Lanzar excepción si el grupo no se encuentra
            skill.setGroup(group); // Asignar el grupo a la habilidad
        }
        return skill;
    }
}

