package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.DisposalGuideline;

public interface DisposalGuidelineService {
   
    public List<DisposalGuideline> getAllGuidelines();
    public DisposalGuideline getGuidelineById(long id);
    public DisposalGuideline addGuideline(DisposalGuideline disposalGuideline);
    public DisposalGuideline updateGuideline(long id,DisposalGuideline disposalGuideline);
    void deleteById(long id);
}
