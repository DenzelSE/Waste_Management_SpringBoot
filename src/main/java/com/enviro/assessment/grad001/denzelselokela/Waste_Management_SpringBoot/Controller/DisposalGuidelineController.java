package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.DisposalGuidelines;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.DisposalGuidelineService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DisposalGuidelineController {
    
    @Autowired
    private DisposalGuidelineService service;

    @GetMapping("/guidelines")
    public ResponseEntity<List<DisposalGuidelines>> getAllGuidelines(){
        return new ResponseEntity<>(service.getAllGuidelines(), HttpStatus.OK);
    }
}
