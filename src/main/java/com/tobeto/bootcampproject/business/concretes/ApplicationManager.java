package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.ApplicationService;
import com.tobeto.bootcampproject.business.request.create.application.CreateApplicationRequest;
import com.tobeto.bootcampproject.business.request.update.ApplicationUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.application.CreateApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetAllApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetApplicationResponse;
import com.tobeto.bootcampproject.business.responses.update.ApplicationUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessResult;
import com.tobeto.bootcampproject.model.entities.Application;
import com.tobeto.bootcampproject.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public DataResults<List<GetAllApplicationResponse>>getAll() {
        List<Application> applications= applicationRepository.findAll();
    List<GetAllApplicationResponse> allApplicationResponses=
            applications.stream().map(application -> modelMapperService
                    .forResponse()
                    .map(application,GetAllApplicationResponse.class))
                    .collect(Collectors.toList());

        return new
                SuccessDataResult<List<GetAllApplicationResponse>>
                (allApplicationResponses, "Tüm Application Id'ler sıralandı");

    }

    @Override
    public DataResults<ApplicationUpdateResponse> updateRequest(ApplicationUpdateRequest applicationUpdateRequest,int id
    ) {
        Application application=applicationRepository.findById(id).orElseThrow(()-> new RuntimeException("Id bulunumadı."));

        Application applicationUpdate=modelMapperService.forRequest().map(applicationUpdateRequest,Application.class);

        application.setApplicant(applicationUpdate.getApplicant() != null ? applicationUpdate.getApplicant() : application.getApplicant());
        application.setBootcamp(applicationUpdate.getBootcamp() != null ? applicationUpdate.getBootcamp() : application.getBootcamp());
        application.setApplicationState(applicationUpdate.getApplicationState() != null ? applicationUpdate.getApplicationState() : application.getApplicationState());
        application.setUpdateDate(LocalDateTime.now());
        applicationRepository.save(application);

        ApplicationUpdateResponse response = modelMapperService.forResponse()
                .map(application, ApplicationUpdateResponse.class);

        return new SuccessDataResult<ApplicationUpdateResponse>
                (response, "Application başarıyla değiştirildi.");

    }

    @Override
    public Result deleteApplication(int id) {
        applicationRepository.deleteById(id);
        return new SuccessResult("Application Delete");
    }
}
