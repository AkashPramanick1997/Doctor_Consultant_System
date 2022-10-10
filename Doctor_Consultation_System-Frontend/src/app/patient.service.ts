import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { Patient } from './patient';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor( private http : HttpClient) { }

  baseURL="http://localhost:8080/patients";
  newId : String | any;

  getPatient() : Observable<Patient[]>{
    return this.http.get<Patient[]>( this.baseURL)
  }

  getPatientById(id : number) : Observable<Patient>{
    this.newId = this.baseURL+"/"+id;
    return this.http.get<Patient>(this.newId).pipe(
      catchError(this.handleError)
    );
  }

  setPatient(patient : Patient) : Observable<object>{
    return this.http.post<object>(this.baseURL,patient);
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
