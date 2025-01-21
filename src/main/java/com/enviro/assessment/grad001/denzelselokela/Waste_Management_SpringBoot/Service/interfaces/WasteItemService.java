package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteItemDTO;

/**
 * Service interface for managing waste item in the Waste Management Spring Boot application.
 * This interface defines the contract for the operations that can be performed on 
 * DisposalGuidelineDTO objects, including retrieval, creation, updating, and deletion.
 */


public interface WasteItemService {
    public List<WasteItemDTO> getAllWasteItems();
    public WasteItemDTO getWasteItemById(Long id);
    public WasteItemDTO addWasteItem(WasteItemDTO wasteItemDto);
    public WasteItemDTO updateWasteItem(Long id, WasteItemDTO updatedWasteItemDto);
    void deleteWasteItemById(Long id);
}
