package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.RecyclingTipDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.RecyclingTipsServiceImp;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RecyclingTipsController {
    
    @Autowired
    private RecyclingTipsServiceImp service;

    @GetMapping("/tips")
    public ResponseEntity<List<RecyclingTipDTO>> getAllRecyclingTips(){
        return new ResponseEntity<>(
                    service.getAllRecyclingTips(), HttpStatus.OK);
    }
    
    @GetMapping("/tips/{id}")
    public ResponseEntity<RecyclingTipDTO> getRecyclingTipById(
                            @PathVariable Long id){
        
        RecyclingTipDTO recyclingTipDto = service.getRecyclingTipById(id);
        return new ResponseEntity<>(recyclingTipDto, HttpStatus.OK);

    }

    @PostMapping("/tips")
    public ResponseEntity<RecyclingTipDTO> addRecyclingTip(
        @RequestBody RecyclingTipDTO recyclingTipDto){
        
            return new ResponseEntity<>(service.addRecyclingTip(
                        recyclingTipDto), HttpStatus.OK);
    }
    @PostMapping("/tips/{id}")
    public ResponseEntity<RecyclingTipDTO> updateRecyclingTip(@PathVariable 
            Long id,@RequestBody RecyclingTipDTO recyclingTipDto){
    
        recyclingTipDto = service.updateRecyclingTipById(id, recyclingTipDto);

        return new ResponseEntity<>(recyclingTipDto, HttpStatus.OK);
        
    }
    @DeleteMapping("tips/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }


}
