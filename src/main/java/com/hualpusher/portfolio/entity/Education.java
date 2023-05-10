package com.hualpusher.portfolio.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String institution;
    private String degree;
    @Temporal(TemporalType.DATE)
    private Date from;
    @Temporal(TemporalType.DATE)
    private Date to;
    private String description;
}