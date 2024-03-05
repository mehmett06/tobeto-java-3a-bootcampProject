package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampproject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;

public interface BlacklistService {
    DataResults<CreateBlacklistResponse> create(CreateBlacklistRequest request);
}
