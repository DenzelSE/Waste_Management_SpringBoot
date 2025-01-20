package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ControllerTests;



import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller.WasteCategoryController;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteCategoryServiceImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class WasteCategoryControllerTest {

    @Mock
    private WasteCategoryServiceImp service;

    @InjectMocks
    private WasteCategoryController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllcategories() {
        List<WasteCategory> categories = Arrays.asList(new WasteCategory(), new WasteCategory());
        when(service.getAllcategories()).thenReturn(categories);

        ResponseEntity<List<WasteCategory>> response = controller.getAllcategories();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categories, response.getBody());
    }

    @Test
    void getCategoryById_existingCategory() {
        long id = 1L;
        WasteCategory category = new WasteCategory();
        when(service.getCategoryById(id)).thenReturn(category);

        ResponseEntity<WasteCategory> response = controller.getCategoryById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(category, response.getBody());
    }

    @Test
    void getCategoryById_nonExistingCategory() {
        long id = 1L;
        when(service.getCategoryById(id)).thenReturn(null);

        ResponseEntity<WasteCategory> response = controller.getCategoryById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void addCategory() {
        WasteCategory category = new WasteCategory();
        when(service.addCategory(category)).thenReturn(category);

        ResponseEntity<?> response = controller.addCategory(category);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(category, response.getBody());
    }

    @Test
    void updateCategory_success() {
        long id = 1L;
        WasteCategory category = new WasteCategory();
        when(service.updateCategory(id, category)).thenReturn(category);

        ResponseEntity<String> response = controller.updateCategory(id, category);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("updated", response.getBody());
    }

    @Test
    void updateCategory_failure() {
        long id = 1L;
        WasteCategory category = new WasteCategory();
        when(service.updateCategory(id, category)).thenThrow(new RuntimeException());

        ResponseEntity<String> response = controller.updateCategory(id, category);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("failed to update", response.getBody());
    }

    // @Test
    // void deleteCategory_existingCategory() {
    //     long id = 1L;
    //     when(service.getCategoryById(id)).thenReturn(new WasteCategory());

    //     ResponseEntity<String> response = controller.deleteCategory(id);

    //     assertEquals(HttpStatus.OK, response.getStatusCode());
    //     assertEquals("Deleted successfully", response.getBody());
    // }

    // @Test
    // void deleteCategory_nonExistingCategory() {
    //     long id = 1L;
    //     when(service.getCategoryById(id)).thenReturn(null);

    //     ResponseEntity<String> response = controller.deleteCategory(id);

    //     assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    //     assertEquals("failed to delete", response.getBody());
    // }
}