package com.tobeto.bootcampproject.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantUpdateResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String about;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
