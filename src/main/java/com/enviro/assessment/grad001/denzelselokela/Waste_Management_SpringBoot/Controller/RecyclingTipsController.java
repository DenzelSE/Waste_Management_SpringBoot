package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RecyclingTipsController {
    
    @Autowired
    private RecyclingTipsService Tservice;

    @GetMapping("/tips")
    public ResponseEntity<List<RecyclingTips>> getAllTips(){
        return new ResponseEntity<>(Tservice.getAllTips(), HttpStatus.OK);
    }
}
