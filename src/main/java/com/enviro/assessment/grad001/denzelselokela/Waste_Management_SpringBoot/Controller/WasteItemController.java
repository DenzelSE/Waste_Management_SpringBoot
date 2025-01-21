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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteItemDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteItemServiceImp;


/**
 * Controller for managing waste items in the Waste Management Spring Boot application.
 * Handles incoming HTTP requests related to waste item, such as retrieving, adding, 
 * updating, and deleting.
 * 
 * Endpoints:
 *  - GET /api/categories
 *  - GET /api/categories/{id}
 *  - POST /api/categories
 *  - POST /api/categories/{id}
 *  - Delete /api/categories/{id}
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WasteItemController {
    
    @Autowired
    private WasteItemServiceImp service;

    @GetMapping("/items")
    public ResponseEntity<List<WasteItemDTO>> getAllWasteItems(){
        return new ResponseEntity<>(service.getAllWasteItems(), HttpStatus.OK);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<WasteItemDTO> getWasteItemById(@PathVariable Long id){
        
        WasteItemDTO wasteItem = service.getWasteItemById(id);

        return new ResponseEntity<>(wasteItem, HttpStatus.OK);
  
    }

    @PostMapping("/items")
    public ResponseEntity<WasteItemDTO> addWasteItem(@RequestBody WasteItemDTO wasteItemDto){
        
        return new ResponseEntity<>(service.addWasteItem(wasteItemDto),HttpStatus.OK);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteWasteItemById(@PathVariable Long id) {
        
        service.deleteWasteItemById(id);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }

}
