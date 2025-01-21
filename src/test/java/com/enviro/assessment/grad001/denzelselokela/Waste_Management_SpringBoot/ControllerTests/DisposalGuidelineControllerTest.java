package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.ControllerTests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Controller.DisposalGuidelineController;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.DTOs.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Exception.ExceptionHandler;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Service.DisposalGuidelineServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DisposalGuidelineControllerTest {

    @Mock
    private DisposalGuidelineServiceImp service;
    
    @InjectMocks
    private DisposalGuidelineController controller;
    
    
    private MockMvc mockMvc;
    private DisposalGuidelineDTO disposalGuidelineDTO;

    @BeforeEach
    void setUp() {
         mockMvc = MockMvcBuilders.standaloneSetup(controller)
            .setControllerAdvice(new ExceptionHandler()) 
            .build();
        new ObjectMapper();
        
        // Initialize test data
        disposalGuidelineDTO = new DisposalGuidelineDTO();
        disposalGuidelineDTO.setId(1L);
        disposalGuidelineDTO.setName("Paper Recycling");
        disposalGuidelineDTO.setDescription("Separate clean paper items and place in blue recycling bins");
    }
    @Test
    void testGetAllGuidelines() throws Exception {
        List<DisposalGuidelineDTO> guidelines = Arrays.asList(disposalGuidelineDTO);
        when(service.getAllGuidelines()).thenReturn(guidelines);

        mockMvc.perform(get("/api/guidelines")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Paper Recycling"));


        verify(service, times(1)).getAllGuidelines();
    }

    @Test
    void testGetGuidelineById_Found() throws Exception {

        when(service.getGuidelineById(1L)).thenReturn(disposalGuidelineDTO);

        mockMvc.perform(get("/api/guidelines/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Paper Recycling"));

        verify(service, times(1)).getGuidelineById(1L);
    }

    @Test
    void testGetGuidelineById_NotFound() throws Exception {

        when(service.getGuidelineById(1L)).thenReturn(null);

        mockMvc.perform(get("/api/guidelines/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(service, times(1)).getGuidelineById(1L);
    }

    @Test
    void testAddGuideline() throws Exception {

        when(service.addGuideline(any(DisposalGuidelineDTO.class)))
                .thenReturn(disposalGuidelineDTO);

        mockMvc.perform(post("/api/guidelines")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Plastic\",\"description\":\"Recycle\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Paper Recycling"));

    }

    @Test
    void testUpdateGuideline() throws Exception {
 
        when(service.updateGuideline(eq(1L), any(DisposalGuidelineDTO.class)))
            .thenReturn(disposalGuidelineDTO);

        mockMvc.perform(post("/api/guidelines/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Plastic\",\"description\":\"Reuse\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Paper Recycling"))
                .andExpect(jsonPath("$.description")
                            .value("Separate clean paper items and place in blue recycling bins"));

    }

    @Test
    void testDeleteGuideline() throws Exception {

        mockMvc.perform(delete("/api/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("successfully deleted"));

        verify(service, times(1)).deleteById(1L);
    }
}
