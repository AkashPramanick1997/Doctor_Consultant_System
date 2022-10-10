package com.mindtree.Doctor_Consultation_SystemBackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.Doctor_Consultation_SystemBackend.DoctorConsultationSystemBackendApplication;
import com.mindtree.Doctor_Consultation_SystemBackend.entity.Patient;
import com.mindtree.Doctor_Consultation_SystemBackend.repository.PatientRepository;

@SpringBootTest(classes = DoctorConsultationSystemBackendApplication.class)
public class PatientControllerTest {
	
	@Autowired
	PatientRepository patientRepository;
	
	// Get all patient details;
	@Test
	void getAllPatient() {
		List<Patient> patients = patientRepository.findAll();
		Patient patient1 = patients.get(0);
		Patient patient2 = patients.get(1);
		
		assertEquals("Sudipta", patient1.getfName());
		assertEquals( 1002L, patient2.getId());
	}
	
	//Get patient details by using id
	@Test
	void getPatientDetailByUsingId() {
		Patient patient = patientRepository.findById(1002L).orElseThrow();
		
		assertEquals("Priya", patient.getfName());
		assertEquals("Ayan Hussain", patient.getVisitedDoctor());
		
	}

}
