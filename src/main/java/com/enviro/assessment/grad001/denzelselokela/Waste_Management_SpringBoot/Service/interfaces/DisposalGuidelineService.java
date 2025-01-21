package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.DisposalGuidelineDTO;

public interface DisposalGuidelineService {
   
    public List<DisposalGuidelineDTO> getAllGuidelines();
    public DisposalGuidelineDTO getGuidelineById(Long id);
    public DisposalGuidelineDTO addGuideline(DisposalGuidelineDTO disposalGuideline);
    public DisposalGuidelineDTO updateGuideline(Long id,DisposalGuidelineDTO disposalGuideline);
    void deleteById(Long id);
}
