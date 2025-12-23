package com.example.auth_service.dto.res;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class ErrorResponse implements Serializable {
    private int status;
    private String message;

}
