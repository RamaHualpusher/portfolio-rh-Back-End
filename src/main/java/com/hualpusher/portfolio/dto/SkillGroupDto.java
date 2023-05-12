package com.hualpusher.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class SkillGroupDto {
    private Long id;
    private String type;
    private List<SkillDto> items;
}
