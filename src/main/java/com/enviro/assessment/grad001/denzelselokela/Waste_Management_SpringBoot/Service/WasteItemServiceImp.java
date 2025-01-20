package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;
import java.util.Optional;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addWasteItem'");
    }

    @Override
    public WasteItem updateWasteItem(WasteItem updatedWasteItem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateWasteItem'");
    }

    @Override
    public void deleteWasteItemById(long id) {
        repository.deleteById(id);
    }
    
}
