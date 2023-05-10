package com.hualpusher.portfolio.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Social {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String icon;
}