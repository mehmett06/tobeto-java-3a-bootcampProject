package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.request.update.InstructorUpdateRequest;
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
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController extends BaseController {
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateInstructorRequest createInstructorRequest) {
        return handleDataResult(instructorService.create(createInstructorRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(instructorService.get(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(instructorService.getall());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable int id,
            @RequestBody InstructorUpdateRequest request
    ) {
        return handleDataResult(instructorService.update(request, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(
            @PathVariable int id
    ) {
        return handleResult(instructorService.deleteInstructorBy(id));
    }

}
