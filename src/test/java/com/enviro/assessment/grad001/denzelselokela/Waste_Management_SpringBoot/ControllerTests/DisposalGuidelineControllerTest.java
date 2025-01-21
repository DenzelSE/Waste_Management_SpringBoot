package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ControllerTests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller.DisposalGuidelineController;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.DisposalGuidelineServiceImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

public class DisposalGuidelineControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DisposalGuidelineServiceImp service;

    @InjectMocks
    private DisposalGuidelineController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllGuidelines() throws Exception {
        // Arrange
        List<DisposalGuidelineDTO> guidelines = Arrays.asList(
                new DisposalGuidelineDTO(1L, "Plastic", "Recycle"),
                new DisposalGuidelineDTO(2L, "Glass", "Reuse")
        );
        when(service.getAllGuidelines()).thenReturn(guidelines);

        // Act & Assert
        mockMvc.perform(get("/api/guidelines")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Plastic"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Glass"));

        verify(service, times(1)).getAllGuidelines();
    }

    @Test
    void testGetGuidelineById_Found() throws Exception {
        // Arrange
        DisposalGuidelineDTO guideline = new DisposalGuidelineDTO(1L, "Plastic", "Recycle");
        when(service.getGuidelineById(1L)).thenReturn(guideline);

        // Act & Assert
        mockMvc.perform(get("/api/guidelines/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Plastic"));

        verify(service, times(1)).getGuidelineById(1L);
    }

    @Test
    void testGetGuidelineById_NotFound() throws Exception {
        // Arrange
        when(service.getGuidelineById(1L)).thenReturn(null);

        // Act & Assert
        mockMvc.perform(get("/api/guidelines/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(service, times(1)).getGuidelineById(1L);
    }

    @Test
    void testAddGuideline() throws Exception {
        // Arrange
        DisposalGuidelineDTO guideline = new DisposalGuidelineDTO(1L, "Plastic", "Recycle");
        when(service.addGuideline(any(DisposalGuidelineDTO.class))).thenReturn(guideline);

        // Act & Assert
        mockMvc.perform(post("/api/guidelines")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Plastic\",\"description\":\"Recycle\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Plastic"));

        verify(service, times(1)).addGuideline(any(DisposalGuidelineDTO.class));
    }

    @Test
    void testUpdateGuideline() throws Exception {
        // Arrange
        DisposalGuidelineDTO updatedGuideline = new DisposalGuidelineDTO(1L, "Plastic", "Reuse");
        when(service.updateGuideline(eq(1L), any(DisposalGuidelineDTO.class))).thenReturn(updatedGuideline);

        // Act & Assert
        mockMvc.perform(post("/api/guidelines/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Plastic\",\"description\":\"Reuse\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Plastic"))
                .andExpect(jsonPath("$.description").value("Reuse"));

        verify(service, times(1)).updateGuideline(eq(1L), any(DisposalGuidelineDTO.class));
    }

    @Test
    void testDeleteGuideline() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/api/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("successfully deleted"));

        verify(service, times(1)).deleteById(1L);
    }
}
