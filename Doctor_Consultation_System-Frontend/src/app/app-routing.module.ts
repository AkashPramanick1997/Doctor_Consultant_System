import { AddPatientComponent } from './add-patient/add-patient.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { PatientsListComponent } from './patients-list/patients-list.component';
import { DetailsDoctorComponent } from './details-doctor/details-doctor.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';

const routes: Routes = [
  { path : '' , redirectTo : '/doctors' , pathMatch : 'full'},
  { path : 'doctors' , component : DoctorListComponent},
  { path : 'add-doctor' , component : AddDoctorComponent},
  { path : 'doctor' , component : DetailsDoctorComponent},
  { path : 'patients' , component : PatientsListComponent},
  { path : 'add-patient' , component : AddPatientComponent},
  { path : 'patients-deatils' , component : PatientDetailsComponent},
  { path : '**' , component : PageNotFoundComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponent = [ DoctorListComponent, PatientsListComponent ,
                                 PageNotFoundComponent, DetailsDoctorComponent];