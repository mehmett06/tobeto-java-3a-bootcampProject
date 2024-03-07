package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.applicationState.CreateApplicationStateRequest;
import com.tobeto.bootcampproject.business.request.update.ApplicationStateUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.tobeto.bootcampproject.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.tobeto.bootcampproject.business.responses.get.applicationState.GetApplicationStateResponse;
import com.tobeto.bootcampproject.business.responses.update.ApplicationStateUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationStateService {
    DataResults<CreateApplicationStateResponse> createApplicationState(CreateApplicationStateRequest createApplicationStateRequest);

    DataResults<GetApplicationStateResponse> getById(int id);
    DataResults<List<GetAllApplicationStateResponse>> getAll();

    DataResults<ApplicationStateUpdateResponse> updateRequest(ApplicationStateUpdateRequest request, int id);

    Result deleteApplicationState(int id);

}
