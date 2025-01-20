package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.DisposalGuideline;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces.DisposalGuidelineService;

@Service
public class DisposalGuidelineServiceImp implements DisposalGuidelineService {
    
    @Autowired
    private DisposalGuidelineRepository repository;
    
    public List<DisposalGuideline> getAllGuidelines(){
        return repository.findAll();
    }

    @Override
    public DisposalGuideline getGuidelineById(long id) {
        return repository.findById(id).orElseThrow(); //attend to handle exception
    }

    @Override
    public DisposalGuideline addGuideline(DisposalGuideline disposalGuideline) {
        return repository.save(disposalGuideline);
    }

    @Override
    public DisposalGuideline updateGuideline(long id, DisposalGuideline disposalGuideline) {
        disposalGuideline.setDescription(disposalGuideline.getDescription());
        disposalGuideline.setName(disposalGuideline.getName());
        disposalGuideline.setWasteCategory(disposalGuideline.getWasteCategory());
        return repository.save(disposalGuideline);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
