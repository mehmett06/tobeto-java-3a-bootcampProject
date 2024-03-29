package com.tobeto.bootcampproject.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootcampStateUpdateResponse {
    private int id;
    private String name;
}
