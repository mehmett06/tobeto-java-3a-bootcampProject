package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;

public interface ApplicantService {
CreateApplicantResponse create(CreateApplicantRequest createApplicantRequest);
GetApplicantResponse getById(int id);
}
