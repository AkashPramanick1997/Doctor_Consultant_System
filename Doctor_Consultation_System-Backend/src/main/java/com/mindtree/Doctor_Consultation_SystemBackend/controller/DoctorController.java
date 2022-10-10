package com.mindtree.Doctor_Consultation_SystemBackend.controller;

import java.util.List;
import java.util.Optional;

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
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	// create a new Doctor;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	// Return all Doctor Information;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/doctors")
	public List<Doctor> findAllDoctors(){
		return doctorRepository.findAll();
	}
	
	//Retrieve one doctor information
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/doctors/{id}")
	public Doctor finDoctorById(@PathVariable Long id) {
		Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id"+id));
		return doctor;
		
	}
	
	//Retrieve number Of patient for a specific doctor with id;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/doctors/{id}/noofpatients")
	public int retriveNoOfPatientWithDoctorId(@PathVariable Long id){
		Optional<Doctor> doctor = doctorRepository.findById(id);
		if(!doctor.isPresent()) {
			throw new ResourceNotFoundException("No such Doctor availabe with Id"+id);
		}
		
		 List<Patient> patient = doctor.get().getPatient();
		 int count =0;
		 for(Patient p : patient) {
			 	 count++;
		 } 
		 
		 return count;
	}
	
	//Retrieve patient information for a specific doctor with id;
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/doctors/{id}/patients")
		public List<Patient> retriveAllPatientWithDoctorId(@PathVariable Long id){
			Optional<Doctor> doctor = doctorRepository.findById(id);
			if(!doctor.isPresent()) {
				throw new ResourceNotFoundException("No such Doctor availabe with Id"+id);
			}
			 List<Patient> patient = doctor.get().getPatient();
			 return patient;
		}
		
	//create patient with doctor id ;
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping("/doctors/{id}/patients")
		public ResponseEntity<Patient>  createPatient(@PathVariable Long id,@RequestBody Patient patient) {
			 Optional<Doctor> findById = doctorRepository.findById(id);
			 Doctor doctor = findById.get();
			 patient.setDoctor(doctor);
			 patientRepository.save(patient);			 
			 return ResponseEntity.ok(patient);	
		}
	
}
