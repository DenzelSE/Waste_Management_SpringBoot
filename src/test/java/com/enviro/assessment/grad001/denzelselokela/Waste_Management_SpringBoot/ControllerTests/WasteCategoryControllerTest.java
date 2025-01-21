package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ControllerTests;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller.WasteCategoryController;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteCategoryDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.ExceptionHandler;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteCategoryServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class WasteCategoryControllerTest {

    @Mock
    private WasteCategoryServiceImp service;

    @InjectMocks
    private WasteCategoryController controller;

    private MockMvc mockMvc;
    private WasteCategoryDTO categoryDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
            .setControllerAdvice(new ExceptionHandler()) 
            .build();
        new ObjectMapper();

        // Initialize test data
        categoryDTO = new WasteCategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName("Plastic");
        categoryDTO.setDescription("Plastic waste materials");
    }

    @Test
    void getAllCategories_ShouldReturnListOfCategories() throws Exception {
       
        List<WasteCategoryDTO> categories = Arrays.asList(categoryDTO);
        when(service.getAllcategories()).thenReturn(categories);

        mockMvc.perform(get("/api/categories"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(categoryDTO.getId()))
            .andExpect(jsonPath("$[0].name").value(categoryDTO.getName()))
            .andExpect(jsonPath("$[0].description").value(categoryDTO.getDescription()));
    }

    @Test
    void getCategoryById_WithValidId_ShouldReturnCategory() throws Exception {
        
        when(service.getCategoryById(1L)).thenReturn(categoryDTO);
        
        mockMvc.perform(get("/api/categories/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(categoryDTO.getId()))
            .andExpect(jsonPath("$.name").value(categoryDTO.getName()))
            .andExpect(jsonPath("$.description").value(categoryDTO.getDescription()));
    }

    @Test
    void getCategoryById_WithInvalidId_ShouldReturnNotFound() throws Exception {
        
        when(service.getCategoryById(99L))
            .thenThrow(new theNotFoundException("Category", "id", 99L));

       
        mockMvc.perform(get("/api/categories/{id}", 99L))
            .andExpect(status().isNotFound());
    }

    @Test
    void deleteCategory_WithValidId_ShouldReturnSuccess() throws Exception {
        
        doNothing().when(service).deleteById(1L);

        mockMvc.perform(delete("/api/categories/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(content().string("Successfully deleted"));
    }

    @Test
    void deleteCategory_WithInvalidId_ShouldReturnNotFound() throws Exception {
        doNothing().when(service).deleteById(99L);

        mockMvc.perform(delete("/api/categories/{id}", 99L))
            .andExpect(status().isOk())
            .andExpect(content().string("Successfully deleted"));
    }
}
