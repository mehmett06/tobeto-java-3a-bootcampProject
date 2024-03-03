package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.ApplicationService;
import com.tobeto.bootcampproject.business.request.create.application.CreateApplicationRequest;
import com.tobeto.bootcampproject.business.responses.create.application.CreateApplicationResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.Application;
import com.tobeto.bootcampproject.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResults<CreateApplicationResponse> createApplication(CreateApplicationRequest request) {

        Application applicationToCreate = modelMapperService.forRequest()
                .map(request, Application.class);
        applicationToCreate.setCreatedDate(LocalDateTime.now());
        applicationRepository.save(applicationToCreate);

        CreateApplicationResponse response = modelMapperService.forResponse()
                .map(applicationToCreate, CreateApplicationResponse.class);

        return new
                SuccessDataResult<CreateApplicationResponse>
                (response, "Application Created");
    }
}
