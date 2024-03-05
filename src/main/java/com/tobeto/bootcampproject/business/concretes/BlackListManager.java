package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.BlacklistService;
import com.tobeto.bootcampproject.business.request.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampproject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.Blacklist;
import com.tobeto.bootcampproject.repository.BlacklistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlackListManager implements BlacklistService {

    private ModelMapperService modelMapperService;
    private BlacklistRepository blacklistRepository;
    @Override
    public DataResults<CreateBlacklistResponse> create(CreateBlacklistRequest request) {
        Blacklist blacklist = modelMapperService.forRequest()
                .map(request, Blacklist.class);

        blacklistRepository.save(blacklist);

        CreateBlacklistResponse response = modelMapperService
                .forResponse().map(blacklist, CreateBlacklistResponse.class);

        return new SuccessDataResult<CreateBlacklistResponse>
                (response, "Applicant için blacklist eklendi");
    }
}
