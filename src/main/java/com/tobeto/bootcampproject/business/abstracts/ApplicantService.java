package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.request.update.ApplicantUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllAppllicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampproject.business.responses.update.ApplicantUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicantService {
DataResults<CreateApplicantResponse> create(CreateApplicantRequest createApplicantRequest);
DataResults<GetApplicantResponse> getById(int id);
DataResults<List<GetAllAppllicantResponse>> getAll();
DataResults<ApplicantUpdateResponse> updateRequest(ApplicantUpdateRequest applicantUpdateRequest,int id);
Result deleteApplicantBy(int id);
}
