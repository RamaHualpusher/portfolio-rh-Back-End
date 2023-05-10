package com.hualpusher.portfolio.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String position;
    @Temporal(TemporalType.DATE)
    private Date from;
    @Temporal(TemporalType.DATE)
    private Date to;
    private String description;
}