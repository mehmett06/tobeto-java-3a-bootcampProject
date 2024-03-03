package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.application.CreateApplicationRequest;
import com.tobeto.bootcampproject.business.responses.create.application.CreateApplicationResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;

public interface ApplicationService {
DataResults<CreateApplicationResponse> createApplication(CreateApplicationRequest request);

}
