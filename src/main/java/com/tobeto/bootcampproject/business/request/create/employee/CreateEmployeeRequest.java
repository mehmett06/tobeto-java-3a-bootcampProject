package com.tobeto.bootcampproject.business.request.create.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    @NotEmpty(message = "First name can not be empty!")
    @Size(min = 2, max = 50, message = "First name must be at least 2 characters!")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty!")
    @Size(min = 2, max = 60, message = "Last name must be at least 2 characters!")
    private String lastName;

    @NotEmpty(message = "Username can not be empty!")
    @Size(min = 2, max = 30, message = "User name must be at least 2 characters!")
    private String userName;

    @NotEmpty(message = "Email can not be empty!")
    @Email(message = "Enter a valid email format!")
    private String email;

    @NotEmpty(message = "Password can not be empty!")
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters.")
    private String password;

    @NotEmpty(message = "National identity can not be empty!")
    @Size(min = 8, max = 11, message = "National identity must be 11 numbers!")
    private String nationalIdentity;

    @NotNull(message = "Date of birth must not be null.")
    @PastOrPresent(message = "Date of birth must be in the past or present.")
    private Date dateOfBirth;

    @NotEmpty(message = "Position can not be empty!")
    private String position;
}
