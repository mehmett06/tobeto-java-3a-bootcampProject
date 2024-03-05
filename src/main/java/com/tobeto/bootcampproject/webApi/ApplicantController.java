package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.ApplicantService;
import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.request.update.ApplicantUpdateRequest;
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
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController extends BaseController {
    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateApplicantRequest createApplicantRequest) {
        return handleDataResult(applicantService.create(createApplicantRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(applicantService.getById(id));
    }


    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicantService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getUpdate(
            @PathVariable int id,
            @RequestBody @Valid ApplicantUpdateRequest request
    ) {
        return handleDataResult(applicantService.updateRequest(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplicant(
            @PathVariable int id
    ) {
        return handleResult(applicantService.deleteApplicantBy(id));
    }
}
