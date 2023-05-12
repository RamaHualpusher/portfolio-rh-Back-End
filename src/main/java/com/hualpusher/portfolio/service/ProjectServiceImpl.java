package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.ProjectDto;
import com.hualpusher.portfolio.entity.Project;
import com.hualpusher.portfolio.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project, Long> {

    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository repository) {

        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public ProjectDto convertToDto(Project project) {
        return modelMapper.map(project, ProjectDto.class);
    }

    public Project convertToEntity(ProjectDto projectDto) {
        return modelMapper.map(projectDto, Project.class);
    }
}

