package com.tobeto.bootcampproject.business.request.create.bootcamp;

import com.tobeto.bootcampproject.model.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    private String name;
    private Instructor instructor;
}
