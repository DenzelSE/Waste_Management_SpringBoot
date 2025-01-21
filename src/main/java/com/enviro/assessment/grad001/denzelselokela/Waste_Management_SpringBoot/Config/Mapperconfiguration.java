package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up the ModelMapper bean in the Waste Management 
 * Spring Boot application. This class enables the application to use ModelMapper for 
 * object mapping and transformation between DTOs and entities
 */

@Configuration
public class Mapperconfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
