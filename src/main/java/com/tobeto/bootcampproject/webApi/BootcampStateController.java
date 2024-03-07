package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampproject.business.request.create.bootcampState.CreateBootcampStateRequest;
import com.tobeto.bootcampproject.business.request.update.BootcampStateUpdateRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bootcampstate")
@AllArgsConstructor
public class BootcampStateController extends BaseController{
private BootcampStateService bootcampStateService;
    @PostMapping
    public ResponseEntity<?>create(@RequestBody @Valid CreateBootcampStateRequest createBootcampStateRequest){
        return handleDataResult(bootcampStateService.create(createBootcampStateRequest));
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return handleDataResult(bootcampStateService.getById(id));
    }

    @GetMapping(value="/getall")
    public ResponseEntity<?>getByAll(

    ){
        return handleDataResult(bootcampStateService.getByAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>getUpdate(
            @PathVariable int id,
            @RequestBody @Valid BootcampStateUpdateRequest request
    ){
        return handleDataResult(bootcampStateService.updateRequest(request,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBootcampState(
            @PathVariable int id
    ) {
        return handleResult(bootcampStateService.deleteBootcampState(id));
    }
}
