package com.mindtree.Doctor_Consultation_SystemBackend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String fName;
	
	@Column(name = "last_name")
	private String lName;
	
	@Column(name = "visitedDoctor")
	private String visitedDoctor;
	
	@Column(name = "dateOfVisit")
	private Date dateOfVisit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Doctor doctor;
	
	public Patient() {
		
	}

	public Patient(Long id, String fName, String lName, String visitedDoctor, Date dateOfVisit) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getVisitedDoctor() {
		return visitedDoctor;
	}


	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}


	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	

	public Doctor getDoctor( Doctor doctor) {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		 this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", fName=" + fName + ", lName=" + lName + ", visitedDoctor=" + visitedDoctor
				+ ", dateOfVisit=" + dateOfVisit + "]";
	}
	
	
}
