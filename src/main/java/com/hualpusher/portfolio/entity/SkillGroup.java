package com.hualpusher.portfolio.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SkillGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "group_id")
    private List<Skill> items;
}
