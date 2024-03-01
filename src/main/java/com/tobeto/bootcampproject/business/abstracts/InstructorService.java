package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.request.update.InstructorUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.ınstructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetAllnstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetInstructorResponse;
import com.tobeto.bootcampproject.business.responses.update.InstructorUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;

import java.util.List;

public interface InstructorService {
    DataResults<CreateInstructorResponse> create(CreateInstructorRequest createInstructorRequest);
    DataResults<GetInstructorResponse> get(int id);
    DataResults<List<GetAllnstructorResponse>> getall();
    DataResults<InstructorUpdateResponse>update(InstructorUpdateRequest instructorUpdateRequest,int id);
}
