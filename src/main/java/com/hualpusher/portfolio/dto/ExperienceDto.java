package com.hualpusher.portfolio.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExperienceDto {
    private Long id;
    private String company;
    private String position;
    private Date from;
    private Date to;
    private String description;
    private Long userId;
}

