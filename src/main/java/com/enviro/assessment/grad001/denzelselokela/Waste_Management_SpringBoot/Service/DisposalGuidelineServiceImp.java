package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.DisposalGuideline;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces.DisposalGuidelineService;

@Service
public class DisposalGuidelineServiceImp implements DisposalGuidelineService {
    
    @Autowired
    private DisposalGuidelineRepository repository;
    
    @Autowired
    private ModelMapper modelMapper;

    public List<DisposalGuidelineDTO> getAllGuidelines(){
        List<DisposalGuideline> guidelines = repository.findAll();
        
        return guidelines.stream()
                    .map((guideline) -> modelMapper
                    .map(guideline, DisposalGuidelineDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public DisposalGuidelineDTO getGuidelineById(Long id) {
        DisposalGuideline guideline = repository.findById(id)
                        .orElseThrow(() -> new theNotFoundException("category", "id", id)); //plan for exception
        
        return modelMapper.map(guideline, DisposalGuidelineDTO.class);
    }

    @Override
    public DisposalGuidelineDTO addGuideline(DisposalGuidelineDTO disposalGuidelinedDto) {
        DisposalGuideline guideline = modelMapper
                                        .map(disposalGuidelinedDto, DisposalGuideline.class);
        DisposalGuideline guidelineSaved = repository.save(guideline);
        return modelMapper.map(guidelineSaved, DisposalGuidelineDTO.class);
    }

    @Override
    public DisposalGuidelineDTO updateGuideline(Long id, 
                            DisposalGuidelineDTO disposalGuidelinedDto) {
        
        DisposalGuideline guideline = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("category", "id", id));
        
        guideline.setDescription(disposalGuidelinedDto.getDescription());
        guideline.setName(disposalGuidelinedDto.getName());
        guideline.setId(id);

        DisposalGuideline guidelineUpdated = repository.save(guideline);

        return modelMapper.map(guidelineUpdated, DisposalGuidelineDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        DisposalGuideline guideline = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("category", "id", id));

        repository.delete(guideline);
    }

}
