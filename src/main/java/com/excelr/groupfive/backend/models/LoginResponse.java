package com.excelr.groupfive.backend.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResponse {
    private String username;
    private String jwtToken;
}
