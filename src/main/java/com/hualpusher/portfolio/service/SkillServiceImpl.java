package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.SkillDto;
import com.hualpusher.portfolio.entity.Skill;
import com.hualpusher.portfolio.repository.SkillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl extends BaseServiceImpl<Skill, Long> {

    private final ModelMapper modelMapper;

    public SkillServiceImpl(SkillRepository repository) {
        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public SkillDto convertToDto(Skill skill) {
        return modelMapper.map(skill, SkillDto.class);
    }

    public Skill convertToEntity(SkillDto skillDto) {
        return modelMapper.map(skillDto, Skill.class);
    }
}
