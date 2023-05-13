package com.hualpusher.portfolio.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1000)
    private String description;
    private String url;
    private String image;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}