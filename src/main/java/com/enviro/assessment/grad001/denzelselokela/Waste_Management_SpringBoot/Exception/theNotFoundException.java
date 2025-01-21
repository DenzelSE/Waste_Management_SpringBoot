package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class theNotFoundException extends RuntimeException{
    private String errorName;
    private String fieldName;
    private Long fieldValue;

    public theNotFoundException(String errorName, String fieldName, Long fieldValue){
        super(String.format("%s not found",errorName));
        this.errorName = errorName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getErrorName() {
        return errorName;
    }
    public String getFieldName() {
        return fieldName;
    }
    public Long getFieldValue() {
        return fieldValue;
    }
}
