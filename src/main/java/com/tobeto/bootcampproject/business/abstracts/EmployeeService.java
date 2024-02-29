package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;

public interface EmployeeService {
CreateEmployeeResponse create(CreateEmployeeRequest createEmployeeRequest);
}
