package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ServiceTests;

import org.springframework.boot.test.context.SpringBootTest;
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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.DisposalGuideline;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.DisposalGuidelineServiceImp;

@ExtendWith(MockitoExtension.class)
public class DisposalGuidelineServiceImpTest {

    @Mock
    private DisposalGuidelineRepository repository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DisposalGuidelineServiceImp service;

    private DisposalGuideline guideline;
    private DisposalGuidelineDTO guidelineDTO;

    @BeforeEach
    void setUp() {
        guideline = new DisposalGuideline();
        guideline.setId(1L);
        guideline.setName("Plastic");
        guideline.setDescription("Recycle plastic items");

        guidelineDTO = new DisposalGuidelineDTO();
        guidelineDTO.setId(1L);
        guidelineDTO.setName("Plastic");
        guidelineDTO.setDescription("Recycle plastic items");
    }

    @Test
    void getAllGuidelines_ShouldReturnListOfGuidelines() {
        // Arrange
        List<DisposalGuideline> guidelines = Arrays.asList(guideline);
        when(repository.findAll()).thenReturn(guidelines);
        when(modelMapper.map(any(DisposalGuideline.class), eq(DisposalGuidelineDTO.class)))
            .thenReturn(guidelineDTO);

        // Act
        List<DisposalGuidelineDTO> result = service.getAllGuidelines();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(guidelineDTO, result.get(0));
        verify(repository).findAll();
    }

    @Test
    void getGuidelineById_WithValidId_ShouldReturnGuideline() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(guideline));
        when(modelMapper.map(guideline, DisposalGuidelineDTO.class)).thenReturn(guidelineDTO);

        // Act
        DisposalGuidelineDTO result = service.getGuidelineById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(guidelineDTO.getId(), result.getId());
        assertEquals(guidelineDTO.getName(), result.getName());
        verify(repository).findById(1L);
    }

    @Test
    void getGuidelineById_WithInvalidId_ShouldThrowNotFoundException() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(theNotFoundException.class, () -> service.getGuidelineById(99L));
        verify(repository).findById(99L);
    }

    @Test
    void addGuideline_ShouldReturnSavedGuideline() {
        // Arrange
        when(modelMapper.map(guidelineDTO, DisposalGuideline.class)).thenReturn(guideline);
        when(repository.save(any(DisposalGuideline.class))).thenReturn(guideline);
        when(modelMapper.map(guideline, DisposalGuidelineDTO.class)).thenReturn(guidelineDTO);

        // Act
        DisposalGuidelineDTO result = service.addGuideline(guidelineDTO);

        // Assert
        assertNotNull(result);
        assertEquals(guidelineDTO.getName(), result.getName());
        verify(repository).save(any(DisposalGuideline.class));
    }

    @Test
    void updateGuideline_WithValidId_ShouldReturnUpdatedGuideline() {
        // Arrange
        DisposalGuidelineDTO updateDTO = new DisposalGuidelineDTO();
        updateDTO.setName("Updated Plastic");
        updateDTO.setDescription("Updated description");

        when(repository.findById(1L)).thenReturn(Optional.of(guideline));
        when(repository.save(any(DisposalGuideline.class))).thenReturn(guideline);
        when(modelMapper.map(guideline, DisposalGuidelineDTO.class)).thenReturn(guidelineDTO);

        // Act
        DisposalGuidelineDTO result = service.updateGuideline(1L, updateDTO);

        // Assert
        assertNotNull(result);
        verify(repository).findById(1L);
        verify(repository).save(any(DisposalGuideline.class));
    }

    @Test
    void updateGuideline_WithInvalidId_ShouldThrowNotFoundException() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(theNotFoundException.class, 
            () -> service.updateGuideline(99L, guidelineDTO));
        verify(repository).findById(99L);
    }

    @Test
    void deleteById_WithValidId_ShouldDeleteGuideline() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(guideline));
        doNothing().when(repository).delete(guideline);

        // Act
        service.deleteById(1L);

        // Assert
        verify(repository).findById(1L);
        verify(repository).delete(guideline);
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
