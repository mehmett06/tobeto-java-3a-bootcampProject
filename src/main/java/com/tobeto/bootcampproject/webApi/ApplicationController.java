package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.ApplicationService;
import com.tobeto.bootcampproject.business.request.create.application.CreateApplicationRequest;
import com.tobeto.bootcampproject.business.request.update.ApplicationUpdateRequest;
import com.tobeto.bootcampproject.core.aspects.logging.Loggable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController extends BaseController {

    private ApplicationService applicationService;

    @Loggable
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody @Valid CreateApplicationRequest createApplicationRequest
    ) {
        return handleDataResult(applicationService.createApplication(createApplicationRequest));
    }

    @Loggable
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(applicationService.getById(id));
    }

    @Loggable
    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicationService.getAll());
    }

    @Loggable
    @PutMapping("/{id}")
    public ResponseEntity<?> getUpdate(
            @PathVariable int id,
            @RequestBody @Valid ApplicationUpdateRequest request
    ) {
        return handleDataResult(applicationService.updateRequest(request, id));
    }

    @Loggable
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplication(
            @PathVariable int id
    ) {
        return handleResult(applicationService.deleteApplication(id));
    }

}
