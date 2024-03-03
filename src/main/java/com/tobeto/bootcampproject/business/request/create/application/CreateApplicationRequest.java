package com.tobeto.bootcampproject.business.request.create.application;

import com.tobeto.bootcampproject.model.entities.Applicant;
import com.tobeto.bootcampproject.model.entities.ApplicationState;
import com.tobeto.bootcampproject.model.entities.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {
    private Applicant applicant;
    private Bootcamp bootcamp;
    private ApplicationState applicationState;
}
