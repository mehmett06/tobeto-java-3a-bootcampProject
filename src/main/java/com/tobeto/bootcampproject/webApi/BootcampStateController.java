package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampproject.business.request.create.bootcampState.CreateBootcampStateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bootcampstate")
@AllArgsConstructor
public class BootcampStateController extends BaseController{
private BootcampStateService bootcampStateService;
    @PostMapping
    public ResponseEntity<?>create(@RequestBody CreateBootcampStateRequest createBootcampStateRequest){
        return handleDataResult(bootcampStateService.createBootcampStateResponse(createBootcampStateRequest));
    }
}
