package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.ApplicationService;
import com.tobeto.bootcampproject.business.constants.ApplicantMessage;
import com.tobeto.bootcampproject.business.request.create.application.CreateApplicationRequest;
import com.tobeto.bootcampproject.business.responses.create.application.CreateApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetAllApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetApplicationResponse;
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

    @Override
    public DataResults<GetApplicationResponse> getById(int id) {
        Application getByIdApplication=applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));

        GetApplicationResponse response = modelMapperService.forResponse()
                .map(getByIdApplication, GetApplicationResponse.class);

        return new
                SuccessDataResult<GetApplicationResponse>
                (response,"Application Id bulundu");
    }
}
