package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.ınstructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetInstructorResponse;
import com.tobeto.bootcampproject.core.mapper.ModelMapperService;
import com.tobeto.bootcampproject.model.entities.Instructor;
import com.tobeto.bootcampproject.repository.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreateInstructorResponse create(CreateInstructorRequest createInstructorRequest) {
        Instructor instructorToBeSave=modelMapperService.forRequest()
                .map(createInstructorRequest,Instructor.class);
        instructorRepository.save(instructorToBeSave);

        CreateInstructorResponse response=modelMapperService.forResponse()
                .map(instructorToBeSave,CreateInstructorResponse.class);
        return response;
    }

    @Override
    public GetInstructorResponse get(int id) {
        Instructor getInstructor=instructorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı."));

        GetInstructorResponse response=modelMapperService.forResponse()
                .map(getInstructor,GetInstructorResponse.class);
        return response;
    }
}
