package com.tobeto.bootcampproject.business.responses.create.ınstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String companyName;

}
