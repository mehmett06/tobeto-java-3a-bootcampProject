package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.ApplicantService;
import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllAppllicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController {
    private ApplicantService applicantService;

    @PostMapping
    public CreateApplicantResponse create(@RequestBody CreateApplicantRequest createApplicantRequest
    ) {
        CreateApplicantResponse results = applicantService.create(createApplicantRequest);
        return results;
    }

    @GetMapping(value = "/{id}")
    public GetApplicantResponse get(@PathVariable int id) {
        return applicantService.getById(id);
    }
    @GetMapping(value = "/getall")
    public List<GetAllAppllicantResponse> getAll() {
        return applicantService.getAll();
    }
}
