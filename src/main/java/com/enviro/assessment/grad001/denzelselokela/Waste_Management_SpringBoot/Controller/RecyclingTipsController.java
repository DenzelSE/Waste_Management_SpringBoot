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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.RecyclingTip;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.RecyclingTipsServiceImp;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RecyclingTipsController {
    
    @Autowired
    private RecyclingTipsServiceImp service;

    @GetMapping("/tips")
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips(){
        return new ResponseEntity<>(service.getAllRecyclingTips(), HttpStatus.OK);
    }
    
    @GetMapping("/tips/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable long id){
        RecyclingTip recyclingTip = service.getRecyclingTipById(id);

        if(recyclingTip != null){
            return new ResponseEntity<>(recyclingTip, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(recyclingTip, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tips")
    public ResponseEntity<RecyclingTip> addRecyclingTip(
        @RequestBody RecyclingTip recyclingTip){
        return new ResponseEntity<>(service.addRecyclingTip(recyclingTip),
                                    HttpStatus.OK);
    }
    @PostMapping("/tips/{id}")
    public ResponseEntity<String> updateRecyclingTip(@PathVariable long id, 
                    @RequestBody RecyclingTip recyclingTip){
    
        try {
            recyclingTip = service.updateRecyclingTipById(id, recyclingTip);
        } catch (Exception e) {
            return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
        }
        if (recyclingTip != null){
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
        }
    }


}
