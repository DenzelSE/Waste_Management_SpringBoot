package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.RecyclingTipDTO;

/**
 * Service interface for managing recycling tips in the Waste Management Spring Boot application.
 * This interface defines the contract for the operations that can be performed on 
 * DisposalGuidelineDTO objects, including retrieval, creation, updating, and deletion.
 */

public interface RecyclingTipsService {
    public List<RecyclingTipDTO> getAllRecyclingTips();
    public RecyclingTipDTO getRecyclingTipById(Long id);
    public RecyclingTipDTO addRecyclingTip(RecyclingTipDTO recyclingTipDto);
    public RecyclingTipDTO updateRecyclingTipById(Long id, RecyclingTipDTO upDatedRecyclingTipDto);
    void deleteById(Long id);
}
