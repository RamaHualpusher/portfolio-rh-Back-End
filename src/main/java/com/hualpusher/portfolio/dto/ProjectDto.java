package com.hualpusher.portfolio.dto;

import lombok.Data;

@Data
public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private String url;
    private String image;
}
