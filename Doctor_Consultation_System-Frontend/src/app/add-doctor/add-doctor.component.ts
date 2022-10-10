import { Router } from '@angular/router';
import { DoctorService } from './../doctor.service';
import { Doctor } from './../doctor';
import { Component, OnInit } from '@angular/core';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor: Doctor = new Doctor();


  constructor(private doctorService: DoctorService,
    private route: Router) { }

  ngOnInit(): void {
  }

  onFormSubmit() {
    console.log(this.doctor);
    this.saveDoctor();
    alert("Doctor Addition Successfull !")
    this.goTODoctorList();
  }

  saveDoctor() {
    this.doctorService.addDoctor(this.doctor).subscribe(
      data => {console.log("success")
    }
    )
  }

  goTODoctorList(){
    this.route.navigate(['/doctors']);
  }
}
