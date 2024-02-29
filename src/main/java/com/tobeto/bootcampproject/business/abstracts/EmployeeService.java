package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;

import java.util.List;

public interface EmployeeService {
CreateEmployeeResponse create(CreateEmployeeRequest createEmployeeRequest);
GetEmployeeResponse getById(int id);
List<GetAllEmployeeResponse> getAll();
}
