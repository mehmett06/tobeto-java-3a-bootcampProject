package com.tobeto.bootcampproject.business.request.create.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDateTime created;
    private LocalDateTime dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String about;
}
