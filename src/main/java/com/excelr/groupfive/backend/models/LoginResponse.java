package com.excelr.groupfive.backend.models;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResponse {
    private UserDetails userDetails;
    private String jwtToken;
}
