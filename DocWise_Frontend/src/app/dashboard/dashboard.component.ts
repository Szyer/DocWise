import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  searchTerm!: string;
  doctorSuggestions: any[] = [];

  constructor(private doctorService: DoctorService) {}

  searchDoctors() {
    if (this.searchTerm) {
      this.doctorService.searchDoctorsByKeyword(this.searchTerm).subscribe((response: any) => {
        this.doctorSuggestions = response;
      });
    }
  }
}
