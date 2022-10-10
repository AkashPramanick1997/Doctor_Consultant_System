import { PatientService } from './../patient.service';
import { Patient } from './../patient';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.css']
})
export class PatientsListComponent implements OnInit {

  patients : Patient[]=[];

  constructor( private patientService : PatientService) { }

  ngOnInit(): void {

    this.patientService.getPatient().subscribe(
      data => this.patients = data
    )
  }

}
