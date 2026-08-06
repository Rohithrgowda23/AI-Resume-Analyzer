package com.ai.Resume.analyser.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {
    private String username;
    private Boolean isPrevious;
    private String token;

    public LoginResponse(String username, Boolean isPrevious) {
        this.username = username;
        this.isPrevious = isPrevious;
    }
}