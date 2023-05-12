package com.hualpusher.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastname;
    private String alias;
    private String imgProfile;
    private String email;
    private String phone;
    private String address;
    private String profession;
    private String aboutme;

    private List<ExperienceDto> experience;
    private List<EducationDto> education;
    private List<SkillGroupDto> skills;
    private List<ProjectDto> projects;
    private List<SocialDto> social;
}

