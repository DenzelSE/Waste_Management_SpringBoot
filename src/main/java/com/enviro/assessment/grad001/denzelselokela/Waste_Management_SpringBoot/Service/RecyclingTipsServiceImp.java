package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.RecyclingTip;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces.RecyclingTipsService;

@Service
public class RecyclingTipsServiceImp implements RecyclingTipsService{
    
    @Autowired
    private RecyclingTipsRepository repository;


    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        return repository.findAll();
    }

    @Override
    public RecyclingTip getRecyclingTipById(long id) {
        return repository.findById(id).orElseThrow(); // handle properly 
    }

    @Override
    public RecyclingTip addRecyclingTip(RecyclingTip recyclingTip) {
        return repository.save(recyclingTip);
    }

    @Override
    public RecyclingTip updateRecyclingTipById(long id, RecyclingTip recyclingTip) {
        recyclingTip.setTip(recyclingTip.getTip());
        recyclingTip.setId(id);
        recyclingTip.setWasteCategory(recyclingTip.getWasteCategory());
        return repository.save(recyclingTip);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
