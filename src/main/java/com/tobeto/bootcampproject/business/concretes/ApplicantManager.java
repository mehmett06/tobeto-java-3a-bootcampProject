package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.ApplicantService;
import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllAppllicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampproject.core.mapper.ModelMapperService;
import com.tobeto.bootcampproject.model.entities.Applicant;
import com.tobeto.bootcampproject.repository.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {
    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreateApplicantResponse create(CreateApplicantRequest createApplicantRequest) {
        Applicant applicantToCreate = modelMapperService.forRequest()
                .map(createApplicantRequest, Applicant.class);

        applicantRepository.save(applicantToCreate);

        CreateApplicantResponse response = modelMapperService.forResponse()
                .map(applicantToCreate, CreateApplicantResponse.class);

        return response;
    }

    @Override
    public GetApplicantResponse getById(int id) {
        Applicant getByIdApplicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));

        GetApplicantResponse response = modelMapperService.forResponse()
                .map(getByIdApplicant, GetApplicantResponse.class);

        return response;
    }

    @Override
    public List<GetAllAppllicantResponse> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();

        List<GetAllAppllicantResponse> applicantResponse =
                applicants.stream().map(applicant -> modelMapperService
                                .forResponse()
                                .map(applicant, GetAllAppllicantResponse.class))
                        .collect(Collectors.toList());

        return applicantResponse;
    }
}
