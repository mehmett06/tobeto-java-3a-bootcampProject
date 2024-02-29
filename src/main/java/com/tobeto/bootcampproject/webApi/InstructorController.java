package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.InstructorService;
import com.tobeto.bootcampproject.business.request.create.ınstructor.CreateInstructorRequest;
import com.tobeto.bootcampproject.business.responses.create.ınstructor.CreateInstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetAllnstructorResponse;
import com.tobeto.bootcampproject.business.responses.get.ınstructor.GetInstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController {
    private InstructorService instructorService;

    @PostMapping
    public CreateInstructorResponse create(
            @RequestBody CreateInstructorRequest createInstructorRequest
    ) {
        return instructorService.create(createInstructorRequest);
    }

    @GetMapping(value = "/{id}")
    public GetInstructorResponse get(
            @PathVariable int id
    ) {
        return instructorService.get(id);
    }

    @GetMapping(value = "/getall")
    public List<GetAllnstructorResponse> getAll(
    ) {
        return instructorService.getall();
    }
}
