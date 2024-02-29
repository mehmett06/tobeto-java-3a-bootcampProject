package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.ApplicantService;
import com.tobeto.bootcampproject.business.constants.ApplicantMessage;
import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllAppllicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.Applicant;
import com.tobeto.bootcampproject.repository.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {
    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResults<CreateApplicantResponse> create(CreateApplicantRequest createApplicantRequest) {
        Applicant applicantToCreate = modelMapperService.forRequest()
                .map(createApplicantRequest, Applicant.class);
        applicantToCreate.setCreatedDate(LocalDateTime.now());

        applicantRepository.save(applicantToCreate);

        CreateApplicantResponse response = modelMapperService.forResponse()
                .map(applicantToCreate, CreateApplicantResponse.class);

        return new
                SuccessDataResult<CreateApplicantResponse>
                (response, ApplicantMessage.ApplicantAdded);
    }

    @Override
    public DataResults<GetApplicantResponse> getById(int id) {
        Applicant getByIdApplicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));

        GetApplicantResponse response = modelMapperService.forResponse()
                .map(getByIdApplicant, GetApplicantResponse.class);

        return new
                SuccessDataResult<GetApplicantResponse>
                (response, ApplicantMessage.ApplicantBroughtById);
    }

    @Override
    public DataResults<List<GetAllAppllicantResponse>> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();

        List<GetAllAppllicantResponse> applicantResponse =
                applicants.stream().map(applicant -> modelMapperService
                                .forResponse()
                                .map(applicant, GetAllAppllicantResponse.class))
                        .collect(Collectors.toList());

        return new
                SuccessDataResult<List<GetAllAppllicantResponse>>
                (applicantResponse, ApplicantMessage.ApplicantListed);

    }
}
