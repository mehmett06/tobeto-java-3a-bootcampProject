package com.tobeto.bootcampproject.business.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantUpdateRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDateTime created;
    private LocalDateTime dateOfBirth;
    private String nationalIdentity;
    private String about;
}
