package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.ınstructor.CreateInstructorResponse;

public interface InstructorService {
    CreateInstructorResponse create(CreateInstructorRequest createInstructorRequest);
}
