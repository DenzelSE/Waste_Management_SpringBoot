package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteItem;

public interface WasteItemService {
    public List<WasteItem> getAllWasteItems();
    public WasteItem getWasteItemById(long id);
    public WasteItem addWasteItem(WasteItem wasteItem);
    public WasteItem updateWasteItem(WasteItem updatedWasteItem);
}
