package com.example.auth_service.dto.res;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterResponse {
    private int status;
    private String message;
}
