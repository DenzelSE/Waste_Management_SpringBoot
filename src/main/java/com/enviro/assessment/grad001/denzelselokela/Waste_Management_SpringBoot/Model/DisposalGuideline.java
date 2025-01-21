package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a disposal guideline in the Waste Management Spring Boot application. 
 * This class is mapped to the "Disposal_Guidelines" table in the database and defines the attributes 
 * and relationships of a disposal guideline.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Disposal_Guidelines")
public class DisposalGuideline {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    
    @NotBlank
    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private WasteCategory wasteCategory;

}
