package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing recycling tips in the Waste Management 
 * Spring Boot application. This class is used to transfer data between layers of the application.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecyclingTipDTO {
    private Long id;
    private String Tip;
    
    @JsonBackReference
    private WasteCategory wasteCategory;
    
}
