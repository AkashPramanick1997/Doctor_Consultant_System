package com.mindtree.Doctor_Consultation_SystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Doctor_Consultation_SystemBackend.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	

}
