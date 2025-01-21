package com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.enviro.assessment.grad001.denzelselokela.Waste_Management_SpringBoot.Model.DisposalGuideline;

/**
 * /**
 * Repository interface for performing CRUD operations on the DisposalGuideline entity 
 * in the Waste Management Spring Boot application. This interface extends the JpaRepository, 
 * providing pre-defined methods for interacting with the database.
 * 
 */

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long>{
    
}
