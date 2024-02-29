package com.tobeto.bootcampproject.business.request.create.ınstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String companyName;
}
