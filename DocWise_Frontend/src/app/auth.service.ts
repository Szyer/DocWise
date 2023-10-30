import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/patients';

  constructor(private http: HttpClient) {}

  registerPatient(patientData: any): Observable<any> {
 
    
    return this.http.post(`${this.baseUrl}/register`, patientData);
  }

  loginPatient(loginData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, loginData);
  }
}
