package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.RecyclingTip;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.RecyclingTipsServiceImp;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RecyclingTipsController {
    
    @Autowired
    private RecyclingTipsServiceImp Tservice;

    @GetMapping("/tips")
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips(){
        return new ResponseEntity<>(Tservice.getAllRecyclingTips(), HttpStatus.OK);
    }
}
