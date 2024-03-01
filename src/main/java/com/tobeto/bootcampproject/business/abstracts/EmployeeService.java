package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.request.update.EmployeeUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.update.EmployeeUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;

import java.util.List;

public interface EmployeeService {
DataResults<CreateEmployeeResponse> create(CreateEmployeeRequest createEmployeeRequest);
DataResults<GetEmployeeResponse> getById(int id);
DataResults<List<GetAllEmployeeResponse>> getAll();
DataResults<EmployeeUpdateResponse> update(EmployeeUpdateRequest employeeUpdateRequest,int id);
}
