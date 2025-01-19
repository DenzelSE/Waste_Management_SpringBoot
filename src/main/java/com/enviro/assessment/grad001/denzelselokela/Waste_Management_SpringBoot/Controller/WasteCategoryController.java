package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteCategoryService;

@RestController
@CrossOrigin
public class WasteCategoryController {

    @Autowired
    public WasteCategoryService service;

    @GetMapping("/categories")
    public List<WasteCategory> getAllcategories(){
        return service.getAllcategories();
    }

    @GetMapping("/categories/{id}")
    public WasteCategory getCategorybyId(@PathVariable long id){
        return service.getCategorybyId(id);
    }
}

