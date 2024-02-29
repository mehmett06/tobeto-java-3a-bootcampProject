package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.constants.InstructorMessage;
import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.ınstructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetAllnstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetInstructorResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.Instructor;
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

    @Override
    public DataResults<CreateInstructorResponse> create(CreateInstructorRequest createInstructorRequest) {
        Instructor instructorToBeSave = modelMapperService.forRequest()
                .map(createInstructorRequest, Instructor.class);
        instructorToBeSave.setCreatedDate(LocalDateTime.now());
        instructorRepository.save(instructorToBeSave);

        CreateInstructorResponse response = modelMapperService.forResponse()
                .map(instructorToBeSave, CreateInstructorResponse.class);
        return new
                SuccessDataResult<CreateInstructorResponse>
                (response,InstructorMessage.InstructorAdded);
    }

    @Override
    public DataResults<GetInstructorResponse> get(int id) {
        Instructor getInstructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));

        GetInstructorResponse response = modelMapperService.forResponse()
                .map(getInstructor, GetInstructorResponse.class);
        return new
                SuccessDataResult<GetInstructorResponse>
                (response,InstructorMessage.InstructorBroughtById);
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
                (ınstructorResponse,InstructorMessage.InstructorListed);
    }
    }
