package com.mindtree.Doctor_Consultation_SystemBackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Doctor_Consultation_SystemBackend.entity.Doctor;
import com.mindtree.Doctor_Consultation_SystemBackend.entity.Patient;
import com.mindtree.Doctor_Consultation_SystemBackend.exceptin.ResourceNotFoundException;
import com.mindtree.Doctor_Consultation_SystemBackend.repository.DoctorRepository;
import com.mindtree.Doctor_Consultation_SystemBackend.repository.PatientRepository;

@RestController
@RequestMapping("/")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	
//	//create a Patient without doctor id;
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping("/patients")
//	public Patient createPatient(@RequestBody Patient patient) {
//		return patientRepository.save(patient);
//	}
	
	
//	//create One Patient and add doctor id;
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping("/patients")
		public Patient createPatientWithDoctorId(@RequestBody Patient patient) {
			String visitedDoctor = patient.getVisitedDoctor();
			String[] split = visitedDoctor.split(" ");
			Doctor newDoctor = doctorRepository.findByFirstNameAndLastName(split[0], split[1]);
			patient.setDoctor(newDoctor);
			return patientRepository.save(patient);
		}
	
	//get all patient;
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/patients")
		public List<Patient> findAllPatients(){
			return patientRepository.findAll();
		}
		
	//get single  patient information with specific id;
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/patients/{id}")
		public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
			Patient patient = patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No such patient there in the database with Id "+id));
			return ResponseEntity.ok(patient);
		}
}
