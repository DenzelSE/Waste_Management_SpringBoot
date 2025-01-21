package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.RecyclingTipDTO;

public interface RecyclingTipsService {
    public List<RecyclingTipDTO> getAllRecyclingTips();
    public RecyclingTipDTO getRecyclingTipById(Long id);
    public RecyclingTipDTO addRecyclingTip(RecyclingTipDTO recyclingTipDto);
    public RecyclingTipDTO updateRecyclingTipById(Long id, RecyclingTipDTO upDatedRecyclingTipDto);
    void deleteById(Long id);
}
