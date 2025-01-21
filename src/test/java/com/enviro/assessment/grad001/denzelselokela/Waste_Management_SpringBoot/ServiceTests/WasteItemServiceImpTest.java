package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ServiceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.WasteItemDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.WasteItem;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.WasteItemRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.WasteItemServiceImp;

@ExtendWith(MockitoExtension.class)
public class WasteItemServiceImpTest {

    @Mock
    private WasteItemRepository repository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private WasteItemServiceImp service;

    private WasteItem wasteItem;
    private WasteItemDTO wasteItemDTO;

    @BeforeEach
    void setUp() {
        // Initialize test data
        wasteItem = new WasteItem();
        wasteItem.setId(1L);
        wasteItem.setName("Plastic Bottle");
        wasteItem.setDescription("Empty plastic bottle");
        
        wasteItemDTO = new WasteItemDTO();
        wasteItemDTO.setDescription("Empty plastic bottle");
        wasteItemDTO.setId(1L);
        wasteItemDTO.setName("Plastic Bottle");
    }

    @Test
    void getAllWasteItems_ShouldReturnListOfItems() {
        
        List<WasteItem> items = Arrays.asList(wasteItem);
        when(repository.findAll()).thenReturn(items);
        when(modelMapper.map(any(WasteItem.class), eq(WasteItemDTO.class)))
            .thenReturn(wasteItemDTO);

        List<WasteItemDTO> result = service.getAllWasteItems();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(wasteItemDTO, result.get(0));
        verify(repository).findAll();
    }

    @Test
    void getWasteItemById_WithInvalidId_ShouldThrowNotFoundException() {
        
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(theNotFoundException.class, () -> service.getWasteItemById(99L));
        verify(repository).findById(99L);
    }

    @Test
    void addWasteItem_ShouldReturnSavedItem() {
        
        when(modelMapper.map(wasteItemDTO, WasteItem.class)).thenReturn(wasteItem);
        when(repository.save(any(WasteItem.class))).thenReturn(wasteItem);
        when(modelMapper.map(wasteItem, WasteItemDTO.class)).thenReturn(wasteItemDTO);

        WasteItemDTO result = service.addWasteItem(wasteItemDTO);

        assertNotNull(result);
        assertEquals(wasteItemDTO.getName(), result.getName());
        assertEquals(wasteItemDTO.getDescription(), result.getDescription());
        verify(repository).save(any(WasteItem.class));
    }

}
