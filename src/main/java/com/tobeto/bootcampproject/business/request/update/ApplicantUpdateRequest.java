package com.tobeto.bootcampproject.business.request.update;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantUpdateRequest {
    @NotEmpty(message = "First name can not be empty!")
    @Size(min = 2, max = 60, message = "First name must be at least 2 characters!")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty!")
    @Size(min = 2, max = 60, message = "Last name must be at least 2 characters!")
    private String lastName;

    @NotEmpty(message = "User name can not be empty!")
    @Size(min = 2, max = 30, message = "User name must be at least 2 characters!")
    private String userName;

    @NotEmpty(message = "Date of birth must be int the past!")
    @Size(message = "Date of birth can not be null!")
    private LocalDateTime dateOfBirth;

    @NotEmpty(message = "National identity can not be empty!")
    @Size(min = 2, max = 60, message = "National identity must be 11 numbers!")
    private String nationalIdentity;

    @NotEmpty(message = "Email can not be empty!")
    @Size(min = 2, max = 60, message = "Enter a valid email format!")
    private String email;

    @NotEmpty(message = "Password can not be empty!")
    @Size(min = 2, max = 10, message = "Password must be between 8 and 10 characters.")
    private String password;

    @NotEmpty(message = "First name can not be empty!")
    @Size(max =255 , message = "About field can not be more than 255 characters.")
    private String about;
}
