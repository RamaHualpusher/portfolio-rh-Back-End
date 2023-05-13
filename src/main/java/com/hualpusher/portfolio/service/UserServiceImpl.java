package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.*;
import com.hualpusher.portfolio.entity.*;
import com.hualpusher.portfolio.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> {

    private final ModelMapper modelMapper;
    private final SkillGroupRepository skillGroupRepository;
    private final SkillRepository skillRepository;
    private final ExperienceRepository experienceRepository;
    private final EducationRepository educationRepository;
    private final ProjectRepository projectRepository;
    private final SocialRepository socialRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository,
                           SkillGroupRepository skillGroupRepository,
                           SkillRepository skillRepository,
                           ExperienceRepository experienceRepository,
                           EducationRepository educationRepository,
                           ProjectRepository projectRepository,
                           SocialRepository socialRepository) {
        super(repository);
        this.skillGroupRepository = skillGroupRepository;
        this.skillRepository = skillRepository;
        this.experienceRepository = experienceRepository;
        this.educationRepository = educationRepository;
        this.projectRepository = projectRepository;
        this.socialRepository = socialRepository;
        this.modelMapper = new ModelMapper();
    }

    public UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);

        userDto.setExperience(user.getExperience().stream().map(this::convertExperienceToDto).collect(Collectors.toList()));
        userDto.setEducation(user.getEducation().stream().map(this::convertEducationToDto).collect(Collectors.toList()));
        userDto.setSkills(user.getSkills().stream().map(this::convertSkillGroupToDto).collect(Collectors.toList()));
        userDto.setProjects(user.getProjects().stream().map(this::convertProjectToDto).collect(Collectors.toList()));
        userDto.setSocial(user.getSocial().stream().map(this::convertSocialToDto).collect(Collectors.toList()));

        return userDto;
    }

    public User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        user.setSkills(userDto.getSkills().stream()
                .map(skillGroupDto -> {
                    SkillGroup skillGroup = skillGroupDto.getId() != null ? skillGroupRepository.findById(skillGroupDto.getId()).orElse(new SkillGroup()) : new SkillGroup();
                    skillGroup = modelMapper.map(skillGroupDto, SkillGroup.class);
                    skillGroup.setItems(skillGroupDto.getItems().stream()
                            .map(skillDto -> {
                                Skill skill = skillDto.getId() != null ? skillRepository.findById(skillDto.getId()).orElse(new Skill()) : new Skill();
                                skill = modelMapper.map(skillDto, Skill.class);
                                return skill;
                            })
                            .collect(Collectors.toList())
                    );
                    return skillGroup;
                })
                .collect(Collectors.toList())
        );
        user.setExperience(userDto.getExperience().stream()
                .map(experienceDto -> {
                    Experience experience = experienceDto.getId() != null ? experienceRepository.findById(experienceDto.getId()).orElse(new Experience()) : new Experience();
                    experience = modelMapper.map(experienceDto, Experience.class);
                    return experience;
                })
                .collect(Collectors.toList())
        );

        user.setEducation(userDto.getEducation().stream()
                .map(educationDto -> {
                    Education education = educationDto.getId() != null ? educationRepository.findById(educationDto.getId()).orElse(new Education()) : new Education();
                    education = modelMapper.map(educationDto, Education.class);
                    return education;
                })
                .collect(Collectors.toList())
        );

        user.setProjects(userDto.getProjects().stream()
                .map(projectDto -> {
                    Project project = projectDto.getId() != null ? projectRepository.findById(projectDto.getId()).orElse(new Project()) : new Project();
                    project = modelMapper.map(projectDto, Project.class);
                    return project;
                })
                .collect(Collectors.toList())
        );

        user.setSocial(userDto.getSocial().stream()
                .map(socialDto -> {
                    Social social = socialDto.getId() != null ? socialRepository.findById(socialDto.getId()).orElse(new Social()) : new Social();
                    social = modelMapper.map(socialDto, Social.class);
                    return social;
                })
                .collect(Collectors.toList())
        );

        return user;
    }





    private ExperienceDto convertExperienceToDto(Experience experience) {
        return modelMapper.map(experience, ExperienceDto.class);
    }

    private Experience convertExperienceToEntity(ExperienceDto experienceDto) {
        return modelMapper.map(experienceDto, Experience.class);
    }

    private EducationDto convertEducationToDto(Education education) {
        return modelMapper.map(education, EducationDto.class);
    }

    private Education convertEducationToEntity(EducationDto educationDto) {
        return modelMapper.map(educationDto, Education.class);
    }

    private Skill convertSkillToEntity(SkillDto skillDto) {
        return modelMapper.map(skillDto, Skill.class);
    }

    private SkillGroupDto convertSkillGroupToDto(SkillGroup skillGroup) {
        return modelMapper.map(skillGroup, SkillGroupDto.class);
    }

    private SkillGroup convertSkillGroupToEntity(SkillGroupDto skillGroupDto) {
        return modelMapper.map(skillGroupDto, SkillGroup.class);
    }

    private ProjectDto convertProjectToDto(Project project) {
        return modelMapper.map(project, ProjectDto.class);
    }

    private Project convertProjectToEntity(ProjectDto projectDto) {
        return modelMapper.map(projectDto, Project.class);
    }

    private SocialDto convertSocialToDto(Social social) {
        return modelMapper.map(social, SocialDto.class);
    }

    private Social convertSocialToEntity(SocialDto socialDto) {
        return modelMapper.map(socialDto, Social.class);
    }
}
