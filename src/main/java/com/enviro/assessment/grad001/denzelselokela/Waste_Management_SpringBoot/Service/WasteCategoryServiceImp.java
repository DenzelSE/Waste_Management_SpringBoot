package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteCategoryDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces.WasteCategoryService;

@Service
public class WasteCategoryServiceImp implements WasteCategoryService{

    @Autowired
    private WasteCategoryRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    
    @Override
    public List<WasteCategoryDTO> getAllcategories(){
        List<WasteCategory> categories = repository.findAll();
        
        return categories.stream()
                        .map((category) -> modelMapper
                        .map(category, WasteCategoryDTO.class))
                        .collect(Collectors.toList());
    }

  
    @Override
    public WasteCategoryDTO getCategoryById(Long id){

        WasteCategory category = repository.findById(id)
                    .orElseThrow(() -> new theNotFoundException("Category", "id", id));
        return modelMapper.map(category, WasteCategoryDTO.class);
    }

    @Override
    public WasteCategoryDTO addCategory(WasteCategoryDTO wasteCategoryDto) {
        WasteCategory category = modelMapper.map(wasteCategoryDto, WasteCategory.class);
        WasteCategory categorySaved = repository.save(category);
        return modelMapper.map(categorySaved, WasteCategoryDTO.class);
    }

    @Override
    public WasteCategoryDTO updateCategory(Long id,WasteCategoryDTO wasteCategoryDto) {
        WasteCategory category = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("Category", "id", id));

        category.setDescription(wasteCategoryDto.getDescription());
        category.setName(wasteCategoryDto.getName());
        category.setId(id);

        WasteCategory categoryUpdated = repository.save(category);
        return modelMapper.map(categoryUpdated, WasteCategoryDTO.class);
        }

    @Override
    public void deleteById(Long id) {
        WasteCategory category = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("Category", "id", id));
        repository.delete(category);
    }

}
