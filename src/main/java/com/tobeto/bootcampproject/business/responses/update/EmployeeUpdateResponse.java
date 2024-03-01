package com.tobeto.bootcampproject.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateResponse {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String nationalIdentity;
    private String position;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
