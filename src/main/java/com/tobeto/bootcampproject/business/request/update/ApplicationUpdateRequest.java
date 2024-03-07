package com.tobeto.bootcampproject.business.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUpdateRequest {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
