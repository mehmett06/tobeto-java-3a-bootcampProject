package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.application.CreateApplicationRequest;
import com.tobeto.bootcampproject.business.request.update.ApplicationUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.application.CreateApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetAllApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetApplicationResponse;
import com.tobeto.bootcampproject.business.responses.update.ApplicationUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationService {
DataResults<CreateApplicationResponse> createApplication(CreateApplicationRequest request);

DataResults<GetApplicationResponse>getById(int id);

DataResults<List<GetAllApplicationResponse>>getAll();

DataResults<ApplicationUpdateResponse> updateRequest(ApplicationUpdateRequest applicationUpdateRequest,int id);

Result deleteApplication(int id);
}
