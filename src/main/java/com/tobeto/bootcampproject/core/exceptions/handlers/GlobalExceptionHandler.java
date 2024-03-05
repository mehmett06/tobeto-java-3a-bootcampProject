package com.tobeto.bootcampproject.core.exceptions.handlers;

import com.tobeto.bootcampproject.core.exceptions.problemDetails.BusinessProblemDetails;
import com.tobeto.bootcampproject.core.exceptions.problemDetails.InternalServerErrorProblemDetails;
import com.tobeto.bootcampproject.core.exceptions.problemDetails.ValidationProblemDetails;
import com.tobeto.bootcampproject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampproject.core.exceptions.types.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException){
        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(businessException.getMessage());
        return businessProblemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception){
        Map<String, String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().stream().
                map(error -> validationErrors.put(error.getField(), error.getDefaultMessage())).
                collect(Collectors.toList());

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;

    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerErrorProblemDetails handleDataIntegrityViolationException(DataIntegrityViolationException exception){
        InternalServerErrorProblemDetails detail = new InternalServerErrorProblemDetails();
        detail.setDetail((exception.getMessage()));
        return detail;
    }
}
