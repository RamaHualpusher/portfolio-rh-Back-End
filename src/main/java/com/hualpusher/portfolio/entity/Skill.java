package com.hualpusher.portfolio.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int level;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private SkillGroup group;
}