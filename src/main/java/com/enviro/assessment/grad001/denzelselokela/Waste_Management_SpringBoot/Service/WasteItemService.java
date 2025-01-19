package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteItem;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteItemRepository;

@Service
public class WasteItemService {
    
    @Autowired
    private WasteItemRepository repository;

    public List<WasteItem> getAllItems(){
        return repository.findAll();
    }

    public WasteItem getItemById(long id) {
        return repository.findById(id).get(); //bad way , need fix handling
    }

    public Object addWasteItem(WasteItem wasteItem) {
        return repository.save(wasteItem);
    }
}
