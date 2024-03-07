package com.tobeto.bootcampproject.business.request.update;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootcampStateUpdateRequest {

    @NotNull
    private int id;

    @NotEmpty(message = "Name must not be empty!")
    private String name;
}
