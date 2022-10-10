package com.mindtree.Doctor_Consultation_SystemBackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.Doctor_Consultation_SystemBackend.DoctorConsultationSystemBackendApplication;
import com.mindtree.Doctor_Consultation_SystemBackend.entity.Doctor;
import com.mindtree.Doctor_Consultation_SystemBackend.repository.DoctorRepository;

@SpringBootTest(classes = DoctorConsultationSystemBackendApplication.class )
class DoctorControllerTest {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Test
	void contextLoads() {
	}
	// Test for retrieve all Doctors;
	@Test
	void retriveAllDoctorDetails() {
		List<Doctor> doctors = doctorRepository.findAll();
		Doctor doctor = doctors.get(0);
		assertEquals("Ayan", doctor.getfName());
	}
	
	//Test for Find Doctor By id;
	@Test
	void findDoctorById() {
		Doctor doctor = doctorRepository.findById(1L).orElseThrow();
		assertEquals("Ayan", doctor.getfName());
	}
	
	//Test for save a new doctor
	@Test
	void saveDoctor() {
		// Not Required
	}

}
