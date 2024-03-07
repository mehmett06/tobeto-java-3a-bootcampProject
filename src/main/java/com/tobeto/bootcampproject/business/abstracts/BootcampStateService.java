package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.bootcampState.CreateBootcampStateRequest;
import com.tobeto.bootcampproject.business.request.update.BootcampStateUpdateRequest;
import com.tobeto.bootcampproject.business.request.update.BootcampUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcampState.GetBootcampStateResponse;
import com.tobeto.bootcampproject.business.responses.update.BootcampStateUpdateResponse;
import com.tobeto.bootcampproject.business.responses.update.BootcampUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface BootcampStateService {
    DataResults<CreateBootcampStateResponse>create(CreateBootcampStateRequest createBootcampStateRequest);

    DataResults<GetBootcampStateResponse> getById(int id );
    DataResults<List<GetAllBootcampStateResponse>>getByAll();
    DataResults<BootcampStateUpdateResponse> updateRequest(BootcampStateUpdateRequest request,int id);
    Result deleteBootcampState(int id);
}
