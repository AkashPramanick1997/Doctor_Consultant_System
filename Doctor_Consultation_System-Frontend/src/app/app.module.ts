import { PatientService } from './patient.service';
import { DoctorService } from './doctor.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule , routingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {NgbPaginationModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddPatientComponent } from './add-patient/add-patient.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponent,
    AddDoctorComponent,
    PatientDetailsComponent,
    AddPatientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    NgbPaginationModule,
    NgbAlertModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [ DoctorService,PatientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
