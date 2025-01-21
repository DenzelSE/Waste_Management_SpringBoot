package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisposalGuidelineDTO {
    private Long id;
    private String name;
    private String description;
}
