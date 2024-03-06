package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.bootcamp.CreateBootcampRequest;
import com.tobeto.bootcampproject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcamp.GetBootcampResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;

public interface BootcampService {
    DataResults<CreateBootcampResponse> createBootcampResponse(CreateBootcampRequest createBootcampRequest);
    DataResults<GetBootcampResponse>getById(int id);
    Result deleteBootcamp(int id);
}
