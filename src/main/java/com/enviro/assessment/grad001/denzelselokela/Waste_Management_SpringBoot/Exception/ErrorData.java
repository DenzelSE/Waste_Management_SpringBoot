package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception;

public class ErrorData {
    private String message;
    private String details;

    public ErrorData(String message, String details){
        this.details = details;
        this.message = message;
    }
    public String getDetails() {
        return details;
    }
    public String getMessage() {
        return message;
    }
}
