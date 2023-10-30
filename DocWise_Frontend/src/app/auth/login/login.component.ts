import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  loginError!: string;
  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const loginData = this.loginForm.value;
      this.authService.loginPatient(loginData).subscribe(
        (loginSuccess) => {
          if (loginSuccess) {
            console.log('Patient logged in successfully');
            this.router.navigate(['/dashboard']);
          } else {
            console.error('Login failed');
            this.loginError = 'Login failed. Please check your credentials.';
          }
        },
        (error) => {
          console.error('Login failed:', error);
          this.loginError = 'Login failed. Please try again later.';
        }
      );
    }
  }
}