package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.EducationDto;
import com.hualpusher.portfolio.entity.Education;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.EducationRepository;
import com.hualpusher.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl extends BaseServiceImpl<Education, Long> {
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public EducationServiceImpl(EducationRepository repository) {
        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public EducationDto convertToDto(Education education) {
        EducationDto educationDto = modelMapper.map(education, EducationDto.class);
        educationDto.setUserId(education.getUser().getId()); // Asignar userId de Education a EducationDto
        return educationDto;
    }

    public Education convertToEntity(EducationDto educationDto) {
        Education education = modelMapper.map(educationDto, Education.class);
        if (educationDto.getUserId() != null) {
            User user = userRepository.findById(educationDto.getUserId()) // Buscar el usuario por userId
                    .orElseThrow(() -> new RuntimeException("User not found with id " + educationDto.getUserId())); // Lanzar excepción si el usuario no se encuentra
            education.setUser(user); // Asignar el usuario a la educación
        }
        return education;
    }
}
