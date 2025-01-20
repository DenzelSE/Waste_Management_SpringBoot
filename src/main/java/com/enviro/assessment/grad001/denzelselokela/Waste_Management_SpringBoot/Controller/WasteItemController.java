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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteItem;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteItemServiceImp;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WasteItemController {
    
    @Autowired
    private WasteItemServiceImp service;

    @GetMapping("/items")
    public ResponseEntity<List<WasteItem>> getAllWasteItems(){
        return new ResponseEntity<>(service.getAllWasteItems(), HttpStatus.OK);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<WasteItem> getWasteItemById(@PathVariable long id){
        
        WasteItem wasteItem = service.getWasteItemById(id);

        if(wasteItem != null){
            return new ResponseEntity<>(wasteItem, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(wasteItem, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/items")
    public ResponseEntity<?> addWasteItem(@RequestBody WasteItem wasteItem){
        return new ResponseEntity<>(service.addWasteItem(wasteItem),HttpStatus.OK);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteWasteItemById(@PathVariable long id) {
        try {
            service.deleteWasteItemById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    //PUT Mapping
}
