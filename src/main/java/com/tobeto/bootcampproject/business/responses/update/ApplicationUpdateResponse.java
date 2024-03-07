package com.tobeto.bootcampproject.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUpdateResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
