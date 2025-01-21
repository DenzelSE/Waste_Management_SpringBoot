package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing waste items in the Waste Management 
 * Spring Boot application. This class is used to transfer data between layers of the application.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WasteItemDTO {
    private Long id;
    private String name;
    private String description;
}
