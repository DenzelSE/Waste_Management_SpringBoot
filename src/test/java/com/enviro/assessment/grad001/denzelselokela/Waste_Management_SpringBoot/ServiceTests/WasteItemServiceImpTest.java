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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteCategory;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteItem;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteItemRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteItemServiceImp;

@ExtendWith(MockitoExtension.class)
public class WasteItemServiceImpTest {

    @Mock
    private WasteItemRepository repository;

    @InjectMocks
    private WasteItemServiceImp service;

    private WasteItem wasteItem;
    private WasteCategory category;

    @BeforeEach
    void setUp() {
        // Initialize test data
        category = new WasteCategory();
        category.setId(1L);
        category.setName("Plastic");
        category.setDescription("Plastic materials");

        wasteItem = new WasteItem();
        wasteItem.setId(1L);
        wasteItem.setName("Plastic Bottle");
        wasteItem.setDescription("Empty plastic bottle");
        wasteItem.setWasteCategory(category);
    }

    @Test
    void getAllWasteItems_ShouldReturnListOfItems() {
        // Arrange
        List<WasteItem> items = Arrays.asList(wasteItem);
        when(repository.findAll()).thenReturn(items);

        // Act
        List<WasteItem> result = service.getAllWasteItems();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(wasteItem, result.get(0));
        verify(repository).findAll();
    }

    @Test
    void getWasteItemById_WithValidId_ShouldReturnItem() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(wasteItem));

        // Act
        WasteItem result = service.getWasteItemById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(wasteItem.getId(), result.getId());
        assertEquals(wasteItem.getName(), result.getName());
        assertEquals(wasteItem.getDescription(), result.getDescription());
        assertEquals(wasteItem.getWasteCategory(), result.getWasteCategory());
        verify(repository).findById(1L);
    }

    @Test
    void getWasteItemById_WithInvalidId_ShouldThrowNotFoundException() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(theNotFoundException.class, () -> service.getWasteItemById(99L));
        verify(repository).findById(99L);
    }

    @Test
    void addWasteItem_ShouldReturnSavedItem() {
        // Arrange
        when(repository.save(any(WasteItem.class))).thenReturn(wasteItem);

        // Act
        WasteItem result = service.addWasteItem(wasteItem);

        // Assert
        assertNotNull(result);
        assertEquals(wasteItem.getName(), result.getName());
        assertEquals(wasteItem.getDescription(), result.getDescription());
        assertEquals(wasteItem.getWasteCategory(), result.getWasteCategory());
        verify(repository).save(any(WasteItem.class));
    }

    @Test
    void updateWasteItem_ShouldReturnUpdatedItem() {
        // Arrange
        WasteItem updatedItem = new WasteItem();
        updatedItem.setName("Updated Bottle");
        updatedItem.setDescription("Updated description");
        updatedItem.setWasteCategory(category);

        when(repository.save(any(WasteItem.class))).thenReturn(updatedItem);

        // Act
        WasteItem result = service.updateWasteItem(1L, updatedItem);

        // Assert
        assertNotNull(result);
        assertEquals(updatedItem.getName(), result.getName());
        assertEquals(updatedItem.getDescription(), result.getDescription());
        assertEquals(updatedItem.getWasteCategory(), result.getWasteCategory());
        verify(repository).save(any(WasteItem.class));
    }

    @Test
    void deleteWasteItemById_ShouldDeleteItem() {
        // Arrange
        doNothing().when(repository).deleteById(1L);

        // Act
        service.deleteWasteItemById(1L);

        // Assert
        verify(repository).deleteById(1L);
    }

    @Test
    void deleteWasteItemById_WithInvalidId_ShouldAttemptDeletion() {
        // Arrange
        doNothing().when(repository).deleteById(99L);

        // Act
        service.deleteWasteItemById(99L);

        // Assert
        verify(repository).deleteById(99L);
    }
}
