package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.ApplicantService;
import com.tobeto.bootcampproject.business.constants.ApplicantMessage;
import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.request.update.ApplicantUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetAllAppllicantResponse;
import com.tobeto.bootcampproject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampproject.business.responses.update.ApplicantUpdateResponse;
import com.tobeto.bootcampproject.business.rules.UserBusinessRules;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessResult;
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
    private UserBusinessRules userBusinessRules;


    @Override
    public DataResults<CreateApplicantResponse> create(CreateApplicantRequest createApplicantRequest) {
        userBusinessRules.checkIfEmailExist(createApplicantRequest.getEmail());
        userBusinessRules.checkIfUserNameExist(createApplicantRequest.getUserName());
        userBusinessRules.checkIfNationalIdentıtyExist(createApplicantRequest.getNationalIdentity());

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

    @Override
    public DataResults<ApplicantUpdateResponse> updateRequest(ApplicantUpdateRequest applicantUpdateRequest, int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new RuntimeException("Id bulunumadı."));

        Applicant applicantUpdate = modelMapperService.forRequest().map(applicantUpdateRequest, Applicant.class);

        applicant.setId(id);
        applicant.setFirstName(applicantUpdate.getFirstName() != null ? applicantUpdate.getFirstName() : applicant.getFirstName());
        applicant.setLastName(applicantUpdate.getLastName() != null ? applicantUpdate.getLastName() : applicant.getLastName());
        applicant.setAbout(applicantUpdate.getAbout() != null ? applicantUpdate.getAbout() : applicant.getAbout());
        applicant.setUserName(applicantUpdate.getUserName() != null ? applicantUpdate.getUserName() : applicant.getUserName());
        applicant.setNationalIdentity(applicantUpdate.getNationalIdentity() != null ? applicantUpdate.getNationalIdentity() : applicant.getNationalIdentity());
        applicant.setDateOfBirth((applicantUpdate.getDateOfBirth() != null ? applicantUpdate.getDateOfBirth() : applicant.getDateOfBirth()));

        applicant.setUpdateDate(LocalDateTime.now());

        applicantRepository.save(applicantUpdate);
        ApplicantUpdateResponse applicantUpdateResponse=modelMapperService.forResponse()
                .map(applicant,ApplicantUpdateResponse.class);

        return new SuccessDataResult<ApplicantUpdateResponse>
                (applicantUpdateResponse,"Applicant Updated");
    }

    @Override
    public Result deleteApplicantBy(int id) {
        applicantRepository.deleteById(id);
       return new SuccessResult("Applicant Delete");
    }
}
