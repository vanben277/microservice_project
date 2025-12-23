package com.example.department_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
    private int id;
    private String userName;
    private String departmentName;
}
