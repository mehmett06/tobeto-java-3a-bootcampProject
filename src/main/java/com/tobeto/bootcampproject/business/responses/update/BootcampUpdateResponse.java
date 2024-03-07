package com.tobeto.bootcampproject.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootcampUpdateResponse {
    private String name;
    private int instructorId;
    private  LocalDateTime startDate;
    private  LocalDateTime endDate;
    private int bootcampStateId;
}
