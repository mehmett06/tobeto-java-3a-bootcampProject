package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.constants.InstructorMessage;
import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.request.update.InstructorUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.ınstructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetAllnstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetInstructorResponse;
import com.tobeto.bootcampproject.business.responses.update.InstructorUpdateResponse;
import com.tobeto.bootcampproject.business.rules.UserBusinessRules;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessResult;
import com.tobeto.bootcampproject.model.entities.Instructor;
import com.tobeto.bootcampproject.repository.EmployeeRepository;
import com.tobeto.bootcampproject.repository.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    private final EmployeeRepository employeeRepository;
    private UserBusinessRules userBusinessRules;

    @Override
    public DataResults<CreateInstructorResponse> create(CreateInstructorRequest createInstructorRequest) {
        userBusinessRules.checkIfEmailExist(createInstructorRequest.getEmail());
        userBusinessRules.checkIfUserNameExist(createInstructorRequest.getUserName());
        userBusinessRules.checkIfNationalIdentıtyExist(createInstructorRequest.getNationalIdentity());

        Instructor instructorToBeSave = modelMapperService.forRequest()
                .map(createInstructorRequest, Instructor.class);
        instructorToBeSave.setCreatedDate(LocalDateTime.now());
        instructorRepository.save(instructorToBeSave);

        CreateInstructorResponse response = modelMapperService.forResponse()
                .map(instructorToBeSave, CreateInstructorResponse.class);
        return new
                SuccessDataResult<CreateInstructorResponse>
                (response, InstructorMessage.InstructorAdded);
    }

    @Override
    public DataResults<GetInstructorResponse> get(int id) {
        Instructor getInstructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));

        GetInstructorResponse response = modelMapperService.forResponse()
                .map(getInstructor, GetInstructorResponse.class);
        return new
                SuccessDataResult<GetInstructorResponse>
                (response, InstructorMessage.InstructorBroughtById);
    }

    @Override
    public DataResults<List<GetAllnstructorResponse>> getall() {
        List<Instructor> instructors = instructorRepository.findAll();

        List<GetAllnstructorResponse> ınstructorResponse =
                instructors.stream().map(instructor -> modelMapperService
                                .forResponse()
                                .map(instructor, GetAllnstructorResponse.class))
                        .collect(Collectors.toList());
        return new
                SuccessDataResult<List<GetAllnstructorResponse>>
                (ınstructorResponse, InstructorMessage.InstructorListed);
    }

    @Override
    public DataResults<InstructorUpdateResponse> update(InstructorUpdateRequest instructorUpdateRequest, int id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("Id bulunamadı"));

        Instructor instructorUpdate = modelMapperService.forRequest().map(instructorUpdateRequest, Instructor.class);

        instructor.setId(id);
        instructor.setFirstName(instructorUpdate.getFirstName() != null ? instructorUpdate.getFirstName() : instructor.getFirstName());
        instructor.setLastName(instructorUpdate.getLastName() != null ? instructorUpdate.getLastName() : instructor.getLastName());
        instructor.setUserName(instructorUpdate.getUserName() != null ? instructorUpdate.getUserName() : instructor.getUserName());
        instructor.setNationalIdentity(instructorUpdate.getNationalIdentity() != null ? instructorUpdate.getNationalIdentity() : instructor.getNationalIdentity());
        instructor.setDateOfBirth((instructorUpdate.getDateOfBirth() != null ? instructorUpdate.getDateOfBirth() : instructor.getDateOfBirth()));
        instructor.setCompanyName(instructorUpdate.getCompanyName() != null ? instructorUpdate.getCompanyName() : instructor.getCompanyName());
        instructor.setUpdateDate(LocalDateTime.now());

        instructorRepository.save(instructorUpdate);
        InstructorUpdateResponse response = modelMapperService.forResponse().map(instructor, InstructorUpdateResponse.class);
        return new SuccessDataResult<InstructorUpdateResponse>(response, "InstructorMessage");
    }

    @Override
    public Result deleteInstructorBy(int id) {
        instructorRepository.deleteById(id);
        return new SuccessResult("InstructorDelete");
    }


}
