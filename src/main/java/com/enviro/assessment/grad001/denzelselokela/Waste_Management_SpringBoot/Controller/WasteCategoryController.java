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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteCategoryDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteCategoryServiceImp;


/**
 * Controller for managing waste categories in the Waste Management Spring Boot application.
 * Handles incoming HTTP requests related to waste categories, such as retrieving, adding, 
 * updating, and deleting.
 * 
 * Endpoints:
 *  - GET /api/categories
 *  - GET /api/categories/{id}
 *  - POST /api/categories
 *  - POST /api/categories/{id}
 *  - Delete /api/categories/{id}
 * 
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WasteCategoryController {

    @Autowired
    public WasteCategoryServiceImp service;

    @GetMapping("/categories")
    public ResponseEntity<List<WasteCategoryDTO>> getAllcategories(){
        return new ResponseEntity<>(service.getAllcategories(),HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<WasteCategoryDTO> getCategoryById(@PathVariable Long id){
        
        WasteCategoryDTO wasteCategoryDto = service.getCategoryById(id);
        return new ResponseEntity<>(wasteCategoryDto, HttpStatus.OK);
        
    }

    @PostMapping("/categories")
    public ResponseEntity<WasteCategoryDTO> addCategory(
                @RequestBody WasteCategoryDTO wasteCategoryDto){
        return new ResponseEntity<>(service.addCategory(wasteCategoryDto),HttpStatus.OK);
    }

    @PostMapping("/categories/{id}")
    public ResponseEntity<WasteCategoryDTO> updateCategory(
        @PathVariable Long id, @RequestBody WasteCategoryDTO wasteCategoryDto){
        
            wasteCategoryDto = service.updateCategory(id, wasteCategoryDto);
            return new ResponseEntity<>(wasteCategoryDto, HttpStatus.OK);        
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
    
        service.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}

