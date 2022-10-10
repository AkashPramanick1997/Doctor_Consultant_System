import { error } from '@angular/compiler/src/util';
import { PatientService } from './../patient.service';
import { Patient } from './../patient';
import { Component, OnInit } from '@angular/core';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

  constructor( private patientService : PatientService) { }

  patientId : String | any;
  newPatientId : number = 0;
  patient : Patient = new Patient();
  errorMessage: String |any;
  errorMessageType : boolean |any;

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(typeof(this.patientId));
    this.getPatient(Number(this.patientId))
    console.log(this.patient)
  }

  getPatient(id : number){
    return this.patientService.getPatientById(id).subscribe(
      {
        next: (data) => this.patient = data,
        error: (error) => this.errorMessage = error
      }
    )
  }
}
