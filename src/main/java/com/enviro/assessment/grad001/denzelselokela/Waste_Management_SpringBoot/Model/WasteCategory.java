package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Waste_Categories")
public class WasteCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank
    private String description;
    

    @OneToMany(mappedBy = "wasteCategory",cascade = CascadeType.ALL)
    private List<WasteItem> wasteGuidelines = new ArrayList<>();

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL)
    private List<RecyclingTip> recyclingTips = new ArrayList<>();

    @OneToMany(mappedBy = "wasteCategory",cascade = CascadeType.ALL)
    private List<DisposalGuideline> disposalGuidelines = new ArrayList<>();
}

