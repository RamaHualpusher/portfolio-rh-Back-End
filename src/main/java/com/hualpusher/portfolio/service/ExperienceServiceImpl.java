package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.ExperienceDto;
import com.hualpusher.portfolio.entity.Experience;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.ExperienceRepository;
import com.hualpusher.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceServiceImpl extends BaseServiceImpl<Experience, Long> {
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public ExperienceServiceImpl(ExperienceRepository repository) {
        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public ExperienceDto convertToDto(Experience experience) {
        ExperienceDto experienceDto = modelMapper.map(experience, ExperienceDto.class);
        experienceDto.setUserId(experience.getUser().getId()); // Asignar userId de Experience a ExperienceDto
        return experienceDto;
    }

    public Experience convertToEntity(ExperienceDto experienceDto) {
        Experience experience = modelMapper.map(experienceDto, Experience.class);
        if (experienceDto.getUserId() != null) {
            User user = userRepository.findById(experienceDto.getUserId()) // Buscar el usuario por userId
                    .orElseThrow(() -> new RuntimeException("User not found with id " + experienceDto.getUserId())); // Lanzar excepción si el usuario no se encuentra
            experience.setUser(user); // Asignar el usuario a la experiencia
        }
        return experience;
    }
}

