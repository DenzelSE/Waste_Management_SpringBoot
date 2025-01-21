package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception;

/**
 * Data class representing the structure of error responses in the Waste Management Spring Boot application.
 * This class is used to encapsulate error details and provide meaningful feedback to API clients.
 */

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
