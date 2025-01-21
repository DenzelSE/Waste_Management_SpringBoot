package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteCategoryDTO;

public interface WasteCategoryService {
    public List<WasteCategoryDTO> getAllcategories();
    public WasteCategoryDTO getCategoryById(Long id);
    public WasteCategoryDTO addCategory(WasteCategoryDTO wasteCategoryDto);
    public WasteCategoryDTO updateCategory(Long id,WasteCategoryDTO wasteCategoryDto);
    void deleteById(Long id);

}
