package com.tobeto.bootcampproject.business.responses.create.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String about;
    private LocalDateTime createdTime;
}
