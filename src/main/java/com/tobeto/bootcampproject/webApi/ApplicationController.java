package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.ApplicationService;
import com.tobeto.bootcampproject.business.request.create.application.CreateApplicationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController extends BaseController{

    private ApplicationService applicationService;
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreateApplicationRequest createApplicationRequest
    ){
        return handleDataResult(applicationService.createApplication(createApplicationRequest));
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(applicationService.getById(id));
    }
}
