package com.tobeto.bootcampproject.core.exceptions.problemDetails;

import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setType("https://lms.tobeto.com/exceptions/business");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
