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
    private RecyclingTipsRepository tipsRepository;

    public List<RecyclingTip> getAllTips(){
        return tipsRepository.findAll();
    }

    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRecyclingTips'");
    }

    @Override
    public RecyclingTip getRecyclingTipById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecyclingTipById'");
    }

    @Override
    public RecyclingTip addRecyclingTip(RecyclingTip recyclingTip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRecyclingTip'");
    }

    @Override
    public RecyclingTip updaRecyclingTip(RecyclingTip upDatedRecyclingTip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updaRecyclingTip'");
    }
}
