package com.hualpusher.portfolio.dto;

import lombok.Data;

@Data
public class UserContactDto {
    private Long id;
    private String phone;
    private String email;
    private String address;
}
