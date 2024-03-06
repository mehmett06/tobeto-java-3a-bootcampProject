package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.ApplicationStateService;
import com.tobeto.bootcampproject.business.request.create.applicationState.CreateApplicationStateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicationstate")
@AllArgsConstructor
public class ApplicationStateController extends BaseController{

    private ApplicationStateService applicationStateService;
    @PostMapping
    public ResponseEntity<?>create(
            @RequestBody CreateApplicationStateRequest createApplicationStateRequest
    ){

        return handleDataResult(applicationStateService.createApplicationState(createApplicationStateRequest));
    }

    @GetMapping(value="{id}")
    public ResponseEntity<?>getById(@PathVariable int id){
        return handleDataResult(applicationStateService.getById(id));
    }
    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicationStateService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplicationState(
            @PathVariable int id
    ) {
        return handleResult(applicationStateService.deleteApplicationState(id));
    }

}
