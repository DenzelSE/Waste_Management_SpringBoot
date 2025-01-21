package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.RecyclingTip;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing waste categories in the Waste Management 
 * Spring Boot application. This class is used to transfer data between layers of the application.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WasteCategoryDTO {
    private Long id;
    private String name;
    private String description;

    @JsonManagedReference
    private List<DisposalGuidelineDTO> guidelines;
    @JsonManagedReference
    private List<RecyclingTip> recyclingTips;

    
}
