package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ServiceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteCategoryDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteCategoryServiceImp;

@ExtendWith(MockitoExtension.class)
public class WasteCategoryServiceImpTest {

    @Mock
    private WasteCategoryRepository repository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private WasteCategoryServiceImp service;

    private WasteCategory category;
    private WasteCategoryDTO categoryDTO;

    @BeforeEach
    void setUp() {
        // Initialize test data
        category = new WasteCategory();
        category.setId(1L);
        category.setName("Plastic");
        category.setDescription("Plastic waste materials");

        categoryDTO = new WasteCategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName("Plastic");
        categoryDTO.setDescription("Plastic waste materials");
    }

    @Test
    void getAllCategories_ShouldReturnListOfCategories() {
        // Arrange
        List<WasteCategory> categories = Arrays.asList(category);
        when(repository.findAll()).thenReturn(categories);
        when(modelMapper.map(any(WasteCategory.class), eq(WasteCategoryDTO.class)))
            .thenReturn(categoryDTO);

        // Act
        List<WasteCategoryDTO> result = service.getAllcategories();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(categoryDTO, result.get(0));
        verify(repository).findAll();
    }

    @Test
    void getCategoryById_WithValidId_ShouldReturnCategory() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(category));
        when(modelMapper.map(category, WasteCategoryDTO.class)).thenReturn(categoryDTO);

        // Act
        WasteCategoryDTO result = service.getCategoryById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(categoryDTO.getId(), result.getId());
        assertEquals(categoryDTO.getName(), result.getName());
        assertEquals(categoryDTO.getDescription(), result.getDescription());
        verify(repository).findById(1L);
    }

    @Test
    void getCategoryById_WithInvalidId_ShouldThrowNotFoundException() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(theNotFoundException.class, () -> service.getCategoryById(99L));
        verify(repository).findById(99L);
    }

    @Test
    void addCategory_ShouldReturnSavedCategory() {
        // Arrange
        when(modelMapper.map(categoryDTO, WasteCategory.class)).thenReturn(category);
        when(repository.save(any(WasteCategory.class))).thenReturn(category);
        when(modelMapper.map(category, WasteCategoryDTO.class)).thenReturn(categoryDTO);

        // Act
        WasteCategoryDTO result = service.addCategory(categoryDTO);

        // Assert
        assertNotNull(result);
        assertEquals(categoryDTO.getName(), result.getName());
        assertEquals(categoryDTO.getDescription(), result.getDescription());
        verify(repository).save(any(WasteCategory.class));
    }

    @Test
    void updateCategory_WithValidId_ShouldReturnUpdatedCategory() {
        // Arrange
        WasteCategoryDTO updateDTO = new WasteCategoryDTO();
        updateDTO.setName("Updated Plastic");
        updateDTO.setDescription("Updated description");

        when(repository.findById(1L)).thenReturn(Optional.of(category));
        when(repository.save(any(WasteCategory.class))).thenReturn(category);
        when(modelMapper.map(category, WasteCategoryDTO.class)).thenReturn(categoryDTO);

        // Act
        WasteCategoryDTO result = service.updateCategory(1L, updateDTO);

        // Assert
        assertNotNull(result);
        verify(repository).findById(1L);
        verify(repository).save(any(WasteCategory.class));
    }

    @Test
    void updateCategory_WithInvalidId_ShouldThrowNotFoundException() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(theNotFoundException.class, 
            () -> service.updateCategory(99L, categoryDTO));
        verify(repository).findById(99L);
    }

    @Test
    void deleteById_WithValidId_ShouldDeleteCategory() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(category));
        doNothing().when(repository).delete(category);

        // Act
        service.deleteById(1L);

        // Assert
        verify(repository).findById(1L);
        verify(repository).delete(category);
    }

    @Test
    void deleteById_WithInvalidId_ShouldThrowNotFoundException() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(theNotFoundException.class, () -> service.deleteById(99L));
        verify(repository).findById(99L);
    }
}