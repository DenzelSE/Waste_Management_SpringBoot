package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.DisposalGuideline;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.DisposalGuidelineServiceImp;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DisposalGuidelineController {
    
    @Autowired
    private DisposalGuidelineServiceImp service;

    @GetMapping("/guidelines")
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines(){
        return new ResponseEntity<>(service.getAllGuidelines(), HttpStatus.OK);
    }

    @GetMapping("/guidelines/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable long id){
        DisposalGuideline guideline = service.getGuidelineById(id);

        if(guideline != null){
            return new ResponseEntity<>(guideline,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(guideline, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/guidelines")
    public ResponseEntity<DisposalGuideline> addGuidline(
        @RequestBody DisposalGuideline disposalGuideline){
            return new ResponseEntity<>(service.addGuideline(disposalGuideline),
                                        HttpStatus.OK);
        }
    @PostMapping("/guidelines/{id}")
        public ResponseEntity<String> updateGuideline(@PathVariable long id, 
                        @RequestBody DisposalGuideline disposalGuideline){

        try {
            disposalGuideline = service.updateGuideline(id, disposalGuideline);
        } catch (Exception e) {
            return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
        }
        if (disposalGuideline != null){
            return new ResponseEntity<>("updated Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
        }
    }
}
