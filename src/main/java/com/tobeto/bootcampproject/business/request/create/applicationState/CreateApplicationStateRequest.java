package com.tobeto.bootcampproject.business.request.create.applicationState;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationStateRequest {

    @NotEmpty(message = "Name must not be empty!")
    private String name;
}
