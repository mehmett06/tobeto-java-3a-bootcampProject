package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.bootcampState.CreateBootcampStateRequest;
import com.tobeto.bootcampproject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;

public interface BootcampStateService {
    DataResults<CreateBootcampStateResponse>createBootcampStateResponse(CreateBootcampStateRequest createBootcampStateRequest);
}
