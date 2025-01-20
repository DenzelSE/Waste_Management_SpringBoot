package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteItem;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteItemRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces.WasteItemService;

@Service
public class WasteItemServiceImp implements WasteItemService{
    
    @Autowired
    private WasteItemRepository repository;

    @Override
    public List<WasteItem> getAllWasteItems() {
        return repository.findAll();
    }

    @Override
    public WasteItem getWasteItemById(long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public WasteItem addWasteItem(WasteItem wasteItem) {
        return repository.save(wasteItem);
    }

    @Override
    public WasteItem updateWasteItem(long id, WasteItem wasteItem) {
        wasteItem.setDescription(wasteItem.getDescription());
        wasteItem.setId(id);
        wasteItem.setName(wasteItem.getName());
        wasteItem.setWasteCategory(wasteItem.getWasteCategory());
        return repository.save(wasteItem);
    }

    @Override
    public void deleteWasteItemById(long id) {
        repository.deleteById(id);
    }
    
}
