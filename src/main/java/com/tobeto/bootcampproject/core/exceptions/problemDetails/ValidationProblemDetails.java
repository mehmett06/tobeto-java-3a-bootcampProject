package com.tobeto.bootcampproject.core.exceptions.problemDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import java.util.Map;
@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationProblemDetails extends ProblemDetails{
    private Map<String, String> errors;
    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setDetail("Validation Problems");
        setType("https://lms.tobeto.com/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
