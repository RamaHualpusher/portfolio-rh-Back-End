package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.ExperienceDto;
import com.hualpusher.portfolio.entity.Experience;
import com.hualpusher.portfolio.repository.ExperienceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceServiceImpl extends BaseServiceImpl<Experience, Long> {

    private final ModelMapper modelMapper;

    public ExperienceServiceImpl(ExperienceRepository repository) {
        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public ExperienceDto convertToDto(Experience experience) {
        return modelMapper.map(experience, ExperienceDto.class);
    }

    public Experience convertToEntity(ExperienceDto experienceDto) {
        return modelMapper.map(experienceDto, Experience.class);
    }
}
