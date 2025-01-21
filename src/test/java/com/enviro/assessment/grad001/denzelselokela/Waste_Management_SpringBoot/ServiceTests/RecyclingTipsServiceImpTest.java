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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.RecyclingTipDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.RecyclingTip;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.RecyclingTipsServiceImp;

@ExtendWith(MockitoExtension.class)
public class RecyclingTipsServiceImpTest {

    @Mock
    private RecyclingTipsRepository repository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private RecyclingTipsServiceImp service;

    private RecyclingTip tip;
    private RecyclingTipDTO tipDTO;

    @BeforeEach
    void setUp() {
        // Initialize test data
        tip = new RecyclingTip();
        tip.setId(1L);
        tip.setTip("Separate paper and plastic");

        tipDTO = new RecyclingTipDTO();
        tipDTO.setId(1L);
        tipDTO.setTip("Separate paper and plastic");
    }

    @Test
    void getAllRecyclingTips_ShouldReturnListOfTips() {
       
        List<RecyclingTip> tips = Arrays.asList(tip);
        when(repository.findAll()).thenReturn(tips);
        when(modelMapper.map(any(RecyclingTip.class), eq(RecyclingTipDTO.class)))
            .thenReturn(tipDTO);

        
        List<RecyclingTipDTO> result = service.getAllRecyclingTips();

        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(tipDTO, result.get(0));
        verify(repository).findAll();
    }

    @Test
    void getRecyclingTipById_WithValidId_ShouldReturnTip() {
       
        when(repository.findById(1L)).thenReturn(Optional.of(tip));
        when(modelMapper.map(tip, RecyclingTipDTO.class)).thenReturn(tipDTO);

        
        RecyclingTipDTO result = service.getRecyclingTipById(1L);

        
        assertNotNull(result);
        assertEquals(tipDTO.getId(), result.getId());
        assertEquals(tipDTO.getTip(), result.getTip());
        verify(repository).findById(1L);
    }

    @Test
    void getRecyclingTipById_WithInvalidId_ShouldThrowNotFoundException() {
       
        when(repository.findById(99L)).thenReturn(Optional.empty());

        
        assertThrows(theNotFoundException.class, () -> service.getRecyclingTipById(99L));
        verify(repository).findById(99L);
    }

    @Test
    void addRecyclingTip_ShouldReturnSavedTip() {
       
        when(modelMapper.map(tipDTO, RecyclingTip.class)).thenReturn(tip);
        when(repository.save(any(RecyclingTip.class))).thenReturn(tip);
        when(modelMapper.map(tip, RecyclingTipDTO.class)).thenReturn(tipDTO);

        
        RecyclingTipDTO result = service.addRecyclingTip(tipDTO);

        
        assertNotNull(result);
        assertEquals(tipDTO.getTip(), result.getTip());
        verify(repository).save(any(RecyclingTip.class));
    }

    @Test
    void updateRecyclingTipById_WithValidId_ShouldReturnUpdatedTip() {
       
        RecyclingTipDTO updateDTO = new RecyclingTipDTO();
        updateDTO.setTip("Updated recycling tip");

        when(repository.findById(1L)).thenReturn(Optional.of(tip));
        when(repository.save(any(RecyclingTip.class))).thenReturn(tip);
        when(modelMapper.map(tip, RecyclingTipDTO.class)).thenReturn(tipDTO);

        
        RecyclingTipDTO result = service.updateRecyclingTipById(1L, updateDTO);

        
        assertNotNull(result);
        verify(repository).findById(1L);
        verify(repository).save(any(RecyclingTip.class));
    }

    @Test
    void updateRecyclingTipById_WithInvalidId_ShouldThrowNotFoundException() {
       
        when(repository.findById(99L)).thenReturn(Optional.empty());

         
        assertThrows(theNotFoundException.class, 
            () -> service.updateRecyclingTipById(99L, tipDTO));
        verify(repository).findById(99L);
    }

    @Test
    void deleteById_WithValidId_ShouldDeleteTip() {
       
        when(repository.findById(1L)).thenReturn(Optional.of(tip));
        doNothing().when(repository).delete(tip);

        
        service.deleteById(1L);

        
        verify(repository).findById(1L);
        verify(repository).delete(tip);
    }

    @Test
    void deleteById_WithInvalidId_ShouldThrowNotFoundException() {
       
        when(repository.findById(99L)).thenReturn(Optional.empty());

        
        assertThrows(theNotFoundException.class, () -> service.deleteById(99L));
        verify(repository).findById(99L);
    }
}
