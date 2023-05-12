package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.EducationDto;
import com.hualpusher.portfolio.entity.Education;
import com.hualpusher.portfolio.repository.EducationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl extends BaseServiceImpl<Education, Long> {

    private final ModelMapper modelMapper;

    public EducationServiceImpl(EducationRepository repository) {

        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public EducationDto convertToDto(Education education) {
        return modelMapper.map(education, EducationDto.class);
    }

    public Education convertToEntity(EducationDto educationDto) {
        return modelMapper.map(educationDto, Education.class);
    }
}