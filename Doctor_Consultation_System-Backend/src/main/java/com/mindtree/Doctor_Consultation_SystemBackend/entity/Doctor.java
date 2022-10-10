package com.mindtree.Doctor_Consultation_SystemBackend.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "first_name")
	private String fName;
	
	@Column(name = "last_name")
	private String lName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "specialist")
	private String specialist;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "doctor")
	private List<Patient> patient;
	
	
	public Doctor() {
		
	}

	public Doctor(Long id, String fName, String lName, int age, String gender, String specialist) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
		this.specialist = specialist;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	
	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + ", gender=" + gender
				+ ", specialist=" + specialist + "]";
	}
	
}
