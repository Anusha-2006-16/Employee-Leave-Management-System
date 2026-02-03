package com.employee.Employee_Leave_Management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role; // STRING, not enum
}
