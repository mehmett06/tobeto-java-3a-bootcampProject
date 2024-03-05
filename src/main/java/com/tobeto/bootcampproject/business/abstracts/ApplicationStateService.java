package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.applicationState.CreateApplicationStateRequest;
import com.tobeto.bootcampproject.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllAppllicantResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.tobeto.bootcampproject.business.responses.get.applicationState.GetApplicationStateResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;

import java.util.List;

public interface ApplicationStateService {
    DataResults<CreateApplicationStateResponse> createApplicationState(CreateApplicationStateRequest createApplicationStateRequest);

    DataResults<GetApplicationStateResponse> getById(int id);
    DataResults<List<GetAllApplicationStateResponse>> getAll();

}
