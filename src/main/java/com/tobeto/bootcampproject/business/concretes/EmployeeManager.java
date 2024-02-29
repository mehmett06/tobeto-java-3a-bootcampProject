package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.EmployeeService;
import com.tobeto.bootcampproject.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampproject.core.mapper.ModelMapperService;
import com.tobeto.bootcampproject.model.entities.Employee;
import com.tobeto.bootcampproject.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreateEmployeeResponse create(CreateEmployeeRequest createEmployeeRequest) {
        Employee employeeToCreate = modelMapperService.forRequest()
                .map(createEmployeeRequest, Employee.class);

        employeeRepository.save(employeeToCreate);
        CreateEmployeeResponse response = modelMapperService.forResponse()
                .map(employeeToCreate, CreateEmployeeResponse.class);
        return response;
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee GetByIdEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));
        GetEmployeeResponse response = modelMapperService.forResponse().
                map(GetByIdEmployee, GetEmployeeResponse.class);
        return response;
    }
}
