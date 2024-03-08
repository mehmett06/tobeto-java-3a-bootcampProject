package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.EmployeeService;
import com.tobeto.bootcampproject.business.constants.EmployeeMessage;
import com.tobeto.bootcampproject.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.request.update.EmployeeUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.update.EmployeeUpdateResponse;
import com.tobeto.bootcampproject.business.rules.UserBusinessRules;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessResult;
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
    private UserBusinessRules userBusinessRules;

    @Override
    public DataResults<CreateEmployeeResponse> create(CreateEmployeeRequest createEmployeeRequest) {
        userBusinessRules.checkIfEmailExist(createEmployeeRequest.getEmail());
        userBusinessRules.checkIfUserNameExist(createEmployeeRequest.getUserName());
        userBusinessRules.checkIfNationalIdentıtyExist(createEmployeeRequest.getNationalIdentity());

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

    @Override
    public DataResults<EmployeeUpdateResponse> update(EmployeeUpdateRequest employeeUpdateRequest,int id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Id bulunamadı."));

        Employee employeeUpdate=modelMapperService.forRequest().map(employeeUpdateRequest,Employee.class);

        employee.setId(id);
        employee.setFirstName(employeeUpdate.getFirstName() !=null ? employeeUpdate.getFirstName() :employee.getFirstName());
        employee.setLastName(employeeUpdate.getLastName() !=null? employeeUpdate.getLastName():employee.getLastName());
        employee.setUserName(employeeUpdate.getUserName() !=null? employeeUpdate.getUserName():employee.getUserName());
        employee.setPosition(employeeUpdate.getPosition()!=null?employeeUpdate.getPosition():employee.getPosition());
        employee.setDateOfBirth(employeeUpdate.getDateOfBirth() !=null?employeeUpdate.getDateOfBirth():employee.getDateOfBirth());

        employee.setUpdateDate(LocalDateTime.now());
        employeeRepository.save(employeeUpdate);
        EmployeeUpdateResponse response=modelMapperService.forResponse().map(employee,EmployeeUpdateResponse.class);

        return new SuccessDataResult<EmployeeUpdateResponse> (response,"EmployeeUpdate");
    }
    @Override
    public Result deleteEmployeeBy(int id) {
        employeeRepository.deleteById(id);
        return new SuccessResult("Employee Delete");
    }
}

