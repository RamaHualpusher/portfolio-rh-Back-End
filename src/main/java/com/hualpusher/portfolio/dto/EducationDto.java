package com.hualpusher.portfolio.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EducationDto {
    private Long id;
    private String institution;
    private String degree;
    private Date from;
    private Date to;
    private String description;
    private Long userId;
}
