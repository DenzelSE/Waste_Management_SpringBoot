package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.RecyclingTip;

public interface RecyclingTipsService {
    public List<RecyclingTip> getAllRecyclingTips();
    public RecyclingTip getRecyclingTipById(long id);
    public RecyclingTip addRecyclingTip(RecyclingTip recyclingTip);
    public RecyclingTip updateRecyclingTipById(long id, RecyclingTip upDatedRecyclingTip);
    void deleteById(long id);
}
