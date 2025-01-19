package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WasteItemController {
    
    @Autowired
    private WasteItemService service;

    @GetMapping("/items")
    public ResponseEntity<List<WasteItem>> getAllItems(){
        return new ResponseEntity<>(service.getAllItems(), HttpStatus.OK);
    }
}
