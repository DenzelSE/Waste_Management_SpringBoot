package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory,Long>{
    
}
