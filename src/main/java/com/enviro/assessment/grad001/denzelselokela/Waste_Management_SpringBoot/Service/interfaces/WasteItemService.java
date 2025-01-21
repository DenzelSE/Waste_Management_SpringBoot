package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteItemDTO;

public interface WasteItemService {
    public List<WasteItemDTO> getAllWasteItems();
    public WasteItemDTO getWasteItemById(Long id);
    public WasteItemDTO addWasteItem(WasteItemDTO wasteItemDto);
    public WasteItemDTO updateWasteItem(Long id, WasteItemDTO updatedWasteItemDto);
    void deleteWasteItemById(Long id);
}
