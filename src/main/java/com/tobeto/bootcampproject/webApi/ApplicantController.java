package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.ApplicantService;
import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController extends BaseController{
    private ApplicantService applicantService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateApplicantRequest createApplicantRequest)
    {
        return handleDataResult(applicantService.create(createApplicantRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?>getById(@PathVariable int id){
        return handleDataResult(applicantService.getById(id));
    }


    @GetMapping(value = "/getall")
    public ResponseEntity<?>getAll()
    {
        return handleDataResult(applicantService.getAll());
    }

}
