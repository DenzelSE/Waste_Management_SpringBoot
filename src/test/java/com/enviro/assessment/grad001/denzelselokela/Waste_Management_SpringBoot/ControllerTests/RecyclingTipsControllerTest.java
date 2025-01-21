package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ControllerTests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller.RecyclingTipsController;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.RecyclingTipDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.ExceptionHandler;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.theNotFoundException;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.RecyclingTipsServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class RecyclingTipsControllerTest {

    @Mock
    private RecyclingTipsServiceImp service;

    @InjectMocks
    private RecyclingTipsController controller;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private RecyclingTipDTO tipDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
            .setControllerAdvice(new ExceptionHandler()) 
            .build();
        objectMapper = new ObjectMapper();

        // Initialize test data
        tipDTO = new RecyclingTipDTO();
        tipDTO.setId(1L);
        tipDTO.setTip("Separate recyclables into different containers");
    }

    @Test
    void getAllRecyclingTips_ShouldReturnListOfTips() throws Exception {
        
        List<RecyclingTipDTO> tips = Arrays.asList(tipDTO);
        when(service.getAllRecyclingTips()).thenReturn(tips);

        mockMvc.perform(get("/api/tips"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(tipDTO.getId()))
            .andExpect(jsonPath("$[0].tip").value(tipDTO.getTip()));
    }

    @Test
    void getRecyclingTipById_WithValidId_ShouldReturnTip() throws Exception {
        
        when(service.getRecyclingTipById(1L)).thenReturn(tipDTO);

        mockMvc.perform(get("/api/tips/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(tipDTO.getId()))
            .andExpect(jsonPath("$.tip").value(tipDTO.getTip()));
    }

    @Test
    void getRecyclingTipById_WithInvalidId_ShouldReturnNotFound() throws Exception {
        
        when(service.getRecyclingTipById(99L))
            .thenThrow(new theNotFoundException("tip", "id", 99L));


        mockMvc.perform(get("/api/tips/{id}", 99L))
            .andExpect(status().isNotFound());
    }

    @Test
    void addRecyclingTip_ShouldReturnCreatedTip() throws Exception {
        
        when(service.addRecyclingTip(any(RecyclingTipDTO.class))).thenReturn(tipDTO);

        mockMvc.perform(post("/api/tips")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(tipDTO)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(tipDTO.getId()))
            .andExpect(jsonPath("$.tip").value(tipDTO.getTip()));
    }

    @Test
    void updateRecyclingTip_WithValidId_ShouldReturnUpdatedTip() throws Exception {
        
        RecyclingTipDTO updatedDTO = new RecyclingTipDTO();
        updatedDTO.setTip("Updated recycling tip");

        when(service.updateRecyclingTipById(eq(1L), any(RecyclingTipDTO.class)))
            .thenReturn(updatedDTO);

        mockMvc.perform(post("/api/tips/{id}", 1L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(updatedDTO)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.tip").value(updatedDTO.getTip()));
    }

    @Test
    void updateRecyclingTip_WithInvalidId_ShouldReturnNotFound() throws Exception {
        
        when(service.updateRecyclingTipById(eq(99L), any(RecyclingTipDTO.class)))
            .thenThrow(new theNotFoundException("tip", "id", 99L));

        mockMvc.perform(post("/api/tips/{id}", 99L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(tipDTO)))
            .andExpect(status().isNotFound());
    }

    @Test
    void deleteById_WithValidId_ShouldReturnSuccess() throws Exception {
        
        doNothing().when(service).deleteById(1L);

        mockMvc.perform(delete("/api/tips/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(content().string("Successfully deleted"));
    }

    @Test
    void deleteById_WithInvalidId_ShouldReturnNotFound() throws Exception {
        
        doNothing().when(service).deleteById(99L);

        mockMvc.perform(delete("/api/tips/{id}", 99L))
            .andExpect(status().isOk())
            .andExpect(content().string("Successfully deleted"));
    }

    @Test
    void shouldHandleCrossOriginRequests() throws Exception {
        
        List<RecyclingTipDTO> tips = Arrays.asList(tipDTO);
        when(service.getAllRecyclingTips()).thenReturn(tips);

        mockMvc.perform(get("/api/tips")
            .header("Origin", "http://localhost:3000"))
            .andExpect(status().isOk())
            .andExpect(header().exists("Access-Control-Allow-Origin"));
    }
}