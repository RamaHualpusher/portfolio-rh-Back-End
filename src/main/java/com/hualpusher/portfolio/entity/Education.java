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
    @Column(name = "start_date")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    private String description;
}
