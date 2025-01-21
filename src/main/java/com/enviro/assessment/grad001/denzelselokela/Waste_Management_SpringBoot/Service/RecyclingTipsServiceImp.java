package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.RecyclingTipDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.RecyclingTip;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces.RecyclingTipsService;

/**
 * Implementation of the RecyclingTipsService interface for managing disposal guidelines 
 * in the Waste Management Spring Boot application. This class contains the business logic 
 * for retrieving, creating, updating, and deleting disposal guidelines.
 */

@Service
public class RecyclingTipsServiceImp implements RecyclingTipsService{
    
    @Autowired
    private RecyclingTipsRepository repository;

    @Autowired 
    private ModelMapper modelMapper;


    @Override
    public List<RecyclingTipDTO> getAllRecyclingTips() {
        List<RecyclingTip> tips = repository.findAll();

        return tips.stream()
                    .map((tip) -> modelMapper
                    .map(tip, RecyclingTipDTO.class))
                    .collect(Collectors.toList());
        
    }

    @Override
    public RecyclingTipDTO getRecyclingTipById(Long id) {
        RecyclingTip tip = repository.findById(id)
                    .orElseThrow(() -> new theNotFoundException("tip", "id", id));



        return modelMapper.map(tip, RecyclingTipDTO.class); // handle properly 
    }

    @Override
    public RecyclingTipDTO addRecyclingTip(RecyclingTipDTO recyclingTipdDto) {
        RecyclingTip tip = modelMapper.map(recyclingTipdDto, RecyclingTip.class);
        RecyclingTip tipSaved = repository.save(tip);
        return modelMapper.map(tipSaved, RecyclingTipDTO.class);
    }

    @Override
    public RecyclingTipDTO updateRecyclingTipById(Long id, RecyclingTipDTO recyclingTipDto){
        RecyclingTip tip = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("tip", "id", id));

        tip.setTip(recyclingTipDto.getTip());
        tip.setId(id);
        
        RecyclingTip tipUpdated = repository.save(tip);
        return modelMapper.map(tipUpdated, RecyclingTipDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        RecyclingTip tip = repository.findById(id)
            .orElseThrow(() -> new theNotFoundException("tip", "id", id));
        repository.delete(tip);
    }
}
