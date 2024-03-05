package com.tobeto.bootcampproject.business.responses.create.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private int instructorId;
    private String name;
    private LocalDate startDate;
    private LocalDate  endDate;
    private int bootcampStateId;
}
