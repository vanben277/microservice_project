package com.example.account_service.dto;

import lombok.Data;

@Data
public class AccountDto {
    private int id;

    private String userName;

    private String firstName;

    private String lastName;

    private int departmentId;
}
