package com.mindtree.Doctor_Consultation_SystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.Doctor_Consultation_SystemBackend.entity.Doctor;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Long>{
	
	@Query("SELECT a FROM Doctor a WHERE fName = ?1 AND lName = ?2")
      Doctor findByFirstNameAndLastName(String firstName, String lastName);
}
