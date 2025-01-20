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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteCategoryServiceImp;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class WasteCategoryController {

    @Autowired
    public WasteCategoryServiceImp service;

    @GetMapping("/categories")
    public ResponseEntity<List<WasteCategory>> getAllcategories(){
        return new ResponseEntity<>(service.getAllcategories(),HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable long id){
        
        WasteCategory wasteCategory = service.getCategoryById(id);

        if(wasteCategory != null){
            return new ResponseEntity<>(wasteCategory, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(wasteCategory, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<WasteCategory> addCategory(@RequestBody WasteCategory wasteCategory){
        return new ResponseEntity<>(service.addCategory(wasteCategory),HttpStatus.OK);
    }

    @PostMapping("/categories/{id}") // TODO fix update
    public ResponseEntity<String> updateCategory(@PathVariable long id, @RequestBody WasteCategory wasteCategory){

        try {
            wasteCategory = service.updateCategory(id, wasteCategory);
        } catch (Exception e) {
            return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
        }
        if (wasteCategory != null){
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable long id){
        service.deleteById(id);
    }
}

