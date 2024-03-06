package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.BootcampService;
import com.tobeto.bootcampproject.business.request.create.bootcamp.CreateBootcampRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bootcamp")
@AllArgsConstructor
public class BootcampController extends BaseController{
    private BootcampService bootcampService;
    @PostMapping
    public ResponseEntity<?>create(@RequestBody @Valid CreateBootcampRequest createBootcampRequest){
        return handleDataResult(bootcampService.createBootcampResponse(createBootcampRequest));
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(bootcampService.getById(id));
    }

    @GetMapping(value="/getall")
    public ResponseEntity<?> getByAll(
    ){
        return handleDataResult(bootcampService.getByAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBootcamp(
            @PathVariable int id
    ) {
        return handleResult(bootcampService.deleteBootcamp(id));
    }

}
