package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.DisposalGuidelineRepository;

@Service
public class DisposalGuidelineService {
    
    @Autowired
    private DisposalGuidelineRepository repository;
    
    public List<DisposalGuidelines> getAllGuidelines(){
        return repository.findAll();
    }

}
