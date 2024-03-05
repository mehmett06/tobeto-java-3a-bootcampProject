package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.ApplicationStateService;
import com.tobeto.bootcampproject.business.constants.ApplicantMessage;
import com.tobeto.bootcampproject.business.request.create.applicationState.CreateApplicationStateRequest;
import com.tobeto.bootcampproject.business.responses.create.applicationState.CreateApplicationStateResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllAppllicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.tobeto.bootcampproject.business.responses.get.applicationState.GetApplicationStateResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.Applicant;
import com.tobeto.bootcampproject.model.entities.ApplicationState;
import com.tobeto.bootcampproject.repository.ApplicationStateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {
    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResults<CreateApplicationStateResponse> createApplicationState(CreateApplicationStateRequest createApplicationStateRequest) {

        ApplicationState applicationState=modelMapperService.forRequest()
                .map(createApplicationStateRequest,ApplicationState.class);

        applicationState.setCreatedDate(LocalDateTime.now());

        applicationStateRepository.save(applicationState);

        CreateApplicationStateResponse response=modelMapperService.forResponse()
                .map(applicationState,CreateApplicationStateResponse.class);
        return new
                SuccessDataResult<CreateApplicationStateResponse>
                (response,"ApplicationState Created");
    }

    @Override
    public DataResults<GetApplicationStateResponse> getById(int id) {
        ApplicationState getByIdApplicationState=applicationStateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));

        GetApplicationStateResponse response = modelMapperService.forResponse()
                .map(getByIdApplicationState, GetApplicationStateResponse.class);

        return new
                SuccessDataResult<GetApplicationStateResponse>
                (response,"ApplicationState Id bulundu");
    }

    @Override
    public DataResults<List<GetAllApplicationStateResponse>> getAll() {
        List<ApplicationState> applicantstate = applicationStateRepository.findAll();

        List<GetAllApplicationStateResponse> applicationStateResponses =
                applicantstate.stream().map(applicationState -> modelMapperService
                                .forResponse()
                                .map(applicationState, GetAllApplicationStateResponse.class))
                        .collect(Collectors.toList());

        return new
                SuccessDataResult<List<GetAllApplicationStateResponse>>
                (applicationStateResponses,"Tüm ApplicationState Id'ler sıralandı");
    }
}
