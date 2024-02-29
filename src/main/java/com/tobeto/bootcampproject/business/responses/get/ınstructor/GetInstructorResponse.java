package com.tobeto.bootcampproject.business.responses.get.ınstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInstructorResponse {
    private String userName;
    private LocalDateTime createdDate;
}
