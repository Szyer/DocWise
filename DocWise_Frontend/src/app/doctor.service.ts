import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseUrl = 'http://localhost:8080/doctors'; // Replace with your actual backend URL

  constructor(private http: HttpClient) {}

  // Fetch doctors by keyword
  searchDoctorsByKeyword(keyword: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/search`, { keyword });
  }

  // Fetch all doctors (if needed)
  getAllDoctors(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getDoctor`);
  }
}
