import { Doctor } from './../doctor';
import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {

  constructor( private doctorService : DoctorService,
                private router : Router) { }

  doctors : Doctor[]=[];

  ngOnInit(): void {
    this.doctorService.getEmployee().subscribe(
      data => this.doctors=data); 
  }
}
