package com.tobeto.bootcampproject.business.responses.get.bootcamp;

import com.tobeto.bootcampproject.model.entities.BootcampState;
import com.tobeto.bootcampproject.model.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBootcampResponse {

    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private BootcampState bootcampStateName;
    private Instructor instructor;

}
