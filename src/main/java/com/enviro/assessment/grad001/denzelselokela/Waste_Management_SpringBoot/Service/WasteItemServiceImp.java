package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteItemDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteItem;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteItemRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces.WasteItemService;

/**
 * Implementation of the WasteItemService interface for managing disposal guidelines 
 * in the Waste Management Spring Boot application. This class contains the business logic 
 * for retrieving, creating, updating, and deleting disposal guidelines.
 */

@Service
public class WasteItemServiceImp implements WasteItemService{
    
    @Autowired
    private WasteItemRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<WasteItemDTO> getAllWasteItems() {
        List<WasteItem> items = repository.findAll();

        return items.stream()
                    .map((item) -> modelMapper
                    .map(item, WasteItemDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public WasteItemDTO getWasteItemById(Long id) {
        WasteItem item = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("item", "id", id));
        
        return modelMapper.map(item, WasteItemDTO.class);
    }

    @Override
    public WasteItemDTO addWasteItem(WasteItemDTO wasteItemdDto) {
        WasteItem item = modelMapper.map(wasteItemdDto, WasteItem.class);
        WasteItem itemSaved = repository.save(item);
        return modelMapper.map(itemSaved, WasteItemDTO.class);
    }

    @Override
    public WasteItemDTO updateWasteItem(Long id, WasteItemDTO wasteItemDto) {
        WasteItem item = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("item", "id", id));

        item.setDescription(wasteItemDto.getDescription());
        item.setId(id);
        item.setName(wasteItemDto.getName());
        
        WasteItem itemUpdated = repository.save(item);
        return modelMapper.map(itemUpdated, WasteItemDTO.class);
    }

    @Override
    public void deleteWasteItemById(Long id) {
        WasteItem item = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("item", "id", id));
        repository.delete(item);
    }
    
}
