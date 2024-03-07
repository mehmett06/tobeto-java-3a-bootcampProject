package com.tobeto.bootcampproject.business.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationStateUpdateRequest {
    private int id;
    private String name;
}
