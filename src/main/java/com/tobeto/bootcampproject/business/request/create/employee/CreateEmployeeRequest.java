package com.tobeto.bootcampproject.business.request.create.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String username;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String position;
}
