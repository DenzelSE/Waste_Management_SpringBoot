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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Waste_Items")
public class WasteItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
 
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory wasteCategory;

}
