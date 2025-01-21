package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ControllerTests;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller.RecyclingTipsController;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.RecyclingTipDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.RecyclingTipsServiceImp;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RecyclingTipsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RecyclingTipsServiceImp service;

    @InjectMocks
    private RecyclingTipsController controller;
    

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllRecyclingTips() throws Exception {
        // Arrange
        List<RecyclingTipDTO> guidelines = Arrays.asList(
                new RecyclingTipDTO(1L, "Tip 1"),
                new RecyclingTipDTO(2L, "Tip 2")
        );
        when(service.getAllRecyclingTips()).thenReturn(guidelines);

        // Act & Assert
        mockMvc.perform(get("/api/tips")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.tip").value("Tip 1"));

        verify(service, times(1)).getAllRecyclingTips();
    }

    @Test
    void testGetRecyclingTipById() throws Exception {
        // Arrange
        RecyclingTipDTO tip = new RecyclingTipDTO(1L, "Tip1");
        when(service.getRecyclingTipById(1L)).thenReturn(tip);

        // Act & Assert
        mockMvc.perform(get("/api/tips/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.tip").value("Tip 1"));

        verify(service, times(1)).getRecyclingTipById(1L);
    }


    @Test
    void testAddRecyclingTip() throws Exception {
        // Arrange
        RecyclingTipDTO tip = new RecyclingTipDTO(1L, "Tip 1");
        when(service.addRecyclingTip(any(RecyclingTipDTO.class))).thenReturn(tip);

        // Act & Assert
        mockMvc.perform(post("/api/tips")
                .content("{\"tip\":\"Tip 1\",\"description\":\"Description 1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.tip").value("Tip 1"));

        verify(service, times(1)).addRecyclingTip(any(RecyclingTipDTO.class));
    }

    @Test
    void testUpdateRecyclingTip() throws Exception {
        // Arrange
        RecyclingTipDTO updatedTip = new RecyclingTipDTO(1L, "Updated Tip 1");
        when(service.updateRecyclingTipById(eq(1L), any(RecyclingTipDTO.class))).thenReturn(updatedTip);

        // Act & Assert
        mockMvc.perform(post("/api/tips/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"tip\":\"Updated Tip\",\"description\":\"Updated Description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.tip").value("Updated Tip"));

        verify(service, times(1)).updateRecyclingTipById(eq(1L), any(RecyclingTipDTO.class));
    }

    @Test
    void testDeleteRecyclingTip() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/api/tips/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("successfully deleted"));

        verify(service, times(1)).deleteById(1L);
    }
}
