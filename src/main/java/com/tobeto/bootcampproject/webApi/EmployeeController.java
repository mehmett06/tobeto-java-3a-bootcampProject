package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.EmployeeService;
import com.tobeto.bootcampproject.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampproject.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampproject.core.mapper.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    @PostMapping
    public CreateEmployeeResponse create(
            @RequestBody CreateEmployeeRequest createEmployeeRequest
    ) {
        CreateEmployeeResponse results = employeeService.create(createEmployeeRequest);
        return results;
    }
    @GetMapping(value = "/{id}")
    GetEmployeeResponse get(
            @PathVariable int id
    ) {
        return employeeService.getById(id);
    }
}
