package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategories;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteCategoryRepository;

@Service
public class WasteCategoryService {

    @Autowired
    public WasteCategoryRepository repository;
    
    public List<WasteCategories> getAllcategories(){
        return repository.findAll();
    }

    // TODOhandle exception properlly
    public WasteCategories getCategoryById(long id){
        return repository.findById(id).get();
    }

    public WasteCategories addCategory(WasteCategories wasteCategory) {
        return repository.save(wasteCategory);
    }

    public WasteCategories updateCategory(long id,WasteCategories wasteCategory) {
        wasteCategory.setDescription(wasteCategory.getDescription());
        wasteCategory.setName(wasteCategory.getName());
        wasteCategory.setId(id);
        return repository.save(wasteCategory);
        }

}
