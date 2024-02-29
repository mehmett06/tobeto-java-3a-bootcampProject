package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.ınstructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetInstructorResponse;

public interface InstructorService {
    CreateInstructorResponse create(CreateInstructorRequest createInstructorRequest);
    GetInstructorResponse get(int id);
}
