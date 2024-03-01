package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.EmployeeService;
import com.tobeto.bootcampproject.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampproject.business.request.update.EmployeeUpdateRequest;
import com.tobeto.bootcampproject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampproject.business.responses.get.employee.GetEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController extends BaseController{

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?>create(@RequestBody CreateEmployeeRequest createEmployeeRequest)
    {
        return handleDataResult(employeeService.create(createEmployeeRequest));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?>getById(@PathVariable int id){
        return handleDataResult(employeeService.getById(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?>getAll(){
        return handleDataResult(employeeService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>getUpdate(
            @PathVariable int id,
            @RequestBody EmployeeUpdateRequest request
    ){
        return handleDataResult(employeeService.update(request,id));
    }

}
