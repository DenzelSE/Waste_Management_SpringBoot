package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler for the Waste Management Spring Boot application.
 * This class provides centralized handling of exceptions throughout the application, 
 * improving consistency and maintainability of error responses.
 */

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
    
    
    public ResponseEntity<ErrorData> handleNotFoundException(
        theNotFoundException exception, WebRequest webRequest){
            ErrorData errorData = new ErrorData(exception.getMessage(),webRequest.getDescription(false));
        
        return new ResponseEntity<>(errorData,HttpStatus.NOT_FOUND);
    }
}
