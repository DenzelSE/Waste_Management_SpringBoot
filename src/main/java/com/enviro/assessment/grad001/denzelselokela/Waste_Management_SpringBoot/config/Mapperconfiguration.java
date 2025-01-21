package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapperconfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
