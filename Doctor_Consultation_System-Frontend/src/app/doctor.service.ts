import { catchError } from 'rxjs/operators';
import { Doctor } from './doctor';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private baseURL = "http://localhost:8080/doctors";
  private newURL =""
  private pURL=""
  private iURL=""
  npURL =""

  constructor( private http : HttpClient) { }

  getEmployee() : Observable<Doctor[]>{
    return this.http.get<Doctor[]>(this.baseURL);
  }

  getDoctorById( id : number) : Observable<Doctor>{
    this.newURL =this.baseURL+"/"+id;
    return this.http.get<Doctor>(this.newURL);
  }

  getNumberOfPatientsByDoctorId( id : number) : Observable<any>{
    this.newURL =this.baseURL+"/"+id;
    this.npURL=this.newURL+"/noofpatients"
    return this.http.get<any>(this.npURL);
  }
  getPatientsByDoctorId(id : number) : Observable<Patient[]>{

    this.pURL = this.baseURL+"/"+id+"/patients";
    return this.http.get<Patient[]>(this.baseURL).pipe(
      catchError(this.handleError)
    )

  }

  addDoctor( doctor : Doctor) : Observable<Doctor>{
    return this.http.post<Doctor>(this.baseURL,doctor);
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('“ No such patient there in the database. “'));
  }
}
