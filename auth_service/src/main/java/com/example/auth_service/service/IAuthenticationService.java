package com.example.auth_service.service;

import com.example.auth_service.dto.req.LoginRequest;
import com.example.auth_service.dto.req.RegisterRequest;
import com.example.auth_service.dto.res.AuthenticationResponse;
import com.example.auth_service.dto.res.RegisterResponse;
import com.example.auth_service.exception.ValidationException;
import jakarta.validation.Valid;

public interface IAuthenticationService {
    RegisterResponse register(@Valid RegisterRequest registerRequest);

    AuthenticationResponse login(@Valid LoginRequest loginRequest);

    AuthenticationResponse refreshToken(String authHeader) throws ValidationException;
}
