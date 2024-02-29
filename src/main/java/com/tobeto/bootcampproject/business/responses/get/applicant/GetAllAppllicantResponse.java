package com.tobeto.bootcampproject.business.responses.get.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllAppllicantResponse {
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String about;
    private LocalDateTime createdTime;
}
