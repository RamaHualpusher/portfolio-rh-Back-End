package com.hualpusher.portfolio.dto;

import lombok.Data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class EducationDto {
    private Long id;
    private String institution;
    private String degree;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;
    private String description;
    private Long userId;
}
