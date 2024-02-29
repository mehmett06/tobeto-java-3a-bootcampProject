package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.EmployeeService;
import com.tobeto.bootcampproject.business.constants.EmployeeMessage;
import com.tobeto.bootcampproject.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.Employee;
import com.tobeto.bootcampproject.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResults<CreateEmployeeResponse> create(CreateEmployeeRequest createEmployeeRequest) {
        Employee employeeToCreate = modelMapperService.forRequest()
                .map(createEmployeeRequest, Employee.class);
        employeeToCreate.setCreatedDate(LocalDateTime.now());

        employeeRepository.save(employeeToCreate);
        CreateEmployeeResponse response = modelMapperService.forResponse()
                .map(employeeToCreate, CreateEmployeeResponse.class);
        return new
                SuccessDataResult<CreateEmployeeResponse>
                (response, EmployeeMessage.EmployeeAdded);
    }

    @Override
    public DataResults<GetEmployeeResponse> getById(int id) {
        Employee GetByIdEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));
        GetEmployeeResponse response = modelMapperService.forResponse().
                map(GetByIdEmployee, GetEmployeeResponse.class);
        return new
                SuccessDataResult<GetEmployeeResponse>
                (response,EmployeeMessage.EmployeeBroughtById);
    }

    @Override
    public DataResults<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employees = employeeRepository.findAll();

        List<GetAllEmployeeResponse> employeResponse =
                employees.stream().map(employee -> modelMapperService
                                .forResponse()
                                .map(employee, GetAllEmployeeResponse.class))
                        .collect(Collectors.toList());

        return new
                SuccessDataResult<List<GetAllEmployeeResponse>>
                (employeResponse,EmployeeMessage.EmployeeListed);
    }
}

