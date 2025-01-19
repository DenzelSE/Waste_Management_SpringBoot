package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteItem;

@Repository
public interface WasteItemRepository extends JpaRepository<WasteItem,Long> {
    
}
