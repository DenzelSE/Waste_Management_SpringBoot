package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.interfaces;

import java.util.List;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;

public interface WasteCategoryService {
    public List<WasteCategory> getAllcategories();
    public WasteCategory getCategoryById(long id);
    public WasteCategory addCategory(WasteCategory wasteCategory);
    public WasteCategory updateCategory(long id,WasteCategory wasteCategory);

}
