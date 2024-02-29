package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.ınstructor.CreateInstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Instructor")
@AllArgsConstructor
public class InstructorController {
    private InstructorService instructorService;

    @PostMapping
    public CreateInstructorResponse create(
            @RequestBody CreateInstructorRequest createInstructorRequest
            ){
    return instructorService.create(createInstructorRequest);
    }
}
