package com.tobeto.bootcampproject.business.request.create.bootcamp;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    @NotEmpty(message = "Name must not be empty!")
    private String name;

    @NotNull(message = "Instructor Id must not be null!")
    private int instructorId;

    @NotNull(message = "Start Date must not be null!")
    private LocalDate startDate;

    @NotNull(message = "End Date must not be null!")
    private  LocalDate endDate;

    @NotNull(message = "Bootcamp State Id must not be null!")
    private int bootcampStateId;
}
