package com.tobeto.bootcampproject.business.request.create.application;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {
    @NotNull(message = "Applicant Id must not be null!")
    private int applicantId;

    @NotNull(message = "Bootcamp Id must not be null!")
    private int bootcampId;

    @NotNull(message = "Bootcamp State Id must not be null!")
    private int applicationStateId;
}
