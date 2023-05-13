package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.ProjectDto;
import com.hualpusher.portfolio.entity.Project;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.ProjectRepository;
import com.hualpusher.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project, Long> {
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository repository) {

        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public ProjectDto convertToDto(Project project) {
        ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);
        projectDto.setUserId(project.getUser().getId()); // Asignar userId de Project a ProjectDto
        return projectDto;
    }

    public Project convertToEntity(ProjectDto projectDto) {
        Project project = modelMapper.map(projectDto, Project.class);
        if (projectDto.getUserId() != null) {
            User user = userRepository.findById(projectDto.getUserId()) // Buscar el usuario por userId
                    .orElseThrow(() -> new RuntimeException("User not found with id " + projectDto.getUserId())); // Lanzar excepción si el usuario no se encuentra
            project.setUser(user); // Asignar el usuario al proyecto
        }
        return project;
    }
}

