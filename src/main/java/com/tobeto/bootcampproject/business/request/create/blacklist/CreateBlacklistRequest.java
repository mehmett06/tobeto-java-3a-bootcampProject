package com.tobeto.bootcampproject.business.request.create.blacklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlacklistRequest {
    private String reason;
    private LocalDateTime date;
    private int applicantId;
}
