import { error } from '@angular/compiler/src/util';
import { Patient } from './../patient';
import { DoctorService } from './../doctor.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-details-doctor',
  templateUrl: './details-doctor.component.html',
  styleUrls: ['./details-doctor.component.css']
})
export class DetailsDoctorComponent implements OnInit {

  constructor( private activatedRoute : ActivatedRoute,
    private doctorService : DoctorService,
    private Router : Router) { }


  ngOnInit(): void {
    console.log(this.getDoctr());
  }

  errorMessage : String =''
  doctorId : any = 0;
  patients : Patient[]=[];

  doctors : Doctor[]=[]

  docId  : String ='' ;
  newDocId : number = 0;

  doctor : Doctor = new Doctor();
  numberOfPatients : number =0
  //submit
  onSubmit(){
    console.log(this.docId)
      this.newDocId=Number(this.docId)
      this.doctorService.getDoctorById( this.newDocId).subscribe(
       {
          next: (data) => this.doctor = data,
          error: (error) => this.errorMessage = error
        }
     )
     this.doctorService.getNumberOfPatientsByDoctorId(this.newDocId).subscribe(
       data => this.numberOfPatients=data
     )
 }

getDoctr(){
  this.doctorService.getEmployee().subscribe(data=>this.doctors=data)
}
}