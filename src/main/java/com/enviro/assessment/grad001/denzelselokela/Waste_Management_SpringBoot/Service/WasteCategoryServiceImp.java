package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces.WasteCategoryService;

@Service
public class WasteCategoryServiceImp implements WasteCategoryService{

    @Autowired
    public WasteCategoryRepository repository;
    
    @Override
    public List<WasteCategory> getAllcategories(){
        return repository.findAll();
    }

    // TODOhandle exception properlly
    @Override
    public WasteCategory getCategoryById(long id){
        return repository.findById(id).orElseThrow();
    }

    @Override
    public WasteCategory addCategory(WasteCategory wasteCategory) {
        return repository.save(wasteCategory);
    }

    @Override
    public WasteCategory updateCategory(long id,WasteCategory wasteCategory) {
        wasteCategory.setDescription(wasteCategory.getDescription());
        wasteCategory.setName(wasteCategory.getName());
        wasteCategory.setId(id);
        return repository.save(wasteCategory);
        }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
