package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.RecyclingTip;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.RecyclingTipsRepository;

@Service
public class RecyclingTipsService {
    
    @Autowired
    private RecyclingTipsRepository tipsRepository;

    public List<RecyclingTip> getAllTips(){

        return tipsRepository.findAll();
    }
}
