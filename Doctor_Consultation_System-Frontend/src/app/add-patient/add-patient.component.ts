import { Patient } from './../patient';
import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  doctors : Doctor[]=[];
  patient : Patient = new Patient();
  constructor( private doctorService : DoctorService, private patientService : PatientService,
     private route: Router) { }

  ngOnInit(): void {
  }

  getAllDoctorName(){
    
    this.doctorService.getEmployee().subscribe(
      data => console.log("success")
    )
  }

  onFormSubmit(){
    console.log(this.patient)
    this.patientService.setPatient(this.patient).subscribe(
      data=>console.log(data)
    )
    alert("Registration Successfull")
    this.goToPatientList();
  }

  goToPatientList(){
    this.route.navigate(['/patients']);
  }
}
