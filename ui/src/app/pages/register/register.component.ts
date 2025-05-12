import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/services/authentication.service';
import { RegisterRequest } from '../../services/models/register-request';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  registerForm: FormGroup;
  errorMsg: string = '';
  isLoading: boolean = false;

  constructor(
    private authService: AuthenticationService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      lastName1: ['', Validators.required],
      lastName2: [''],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  registerAccount(): void {
    this.errorMsg = '';
    this.isLoading = true;

    if (this.registerForm.invalid) {
      this.registerForm.markAllAsTouched();
      this.isLoading = false;
      return;
    }

    const formValue = this.registerForm.value;

    const registerRequest: RegisterRequest = {
      name: formValue.name,
      lastName1: formValue.lastName1,
      lastName2: formValue.lastName2,
      email: formValue.email,
      password: formValue.password,
    };

    this.authService.registerUser({ body: registerRequest }).subscribe({
      next: () => {
        this.isLoading = false;
        this.router.navigate(['activate-account']);
      },
      error: (err) => {
        this.isLoading = false;
        if (err.error?.validationErrors) {
          this.errorMsg = err.error.validationErrors.join(', ');
        } else if (err.error?.error) {
          this.errorMsg = err.error.error;
        } else {
          this.errorMsg = 'Ocurrió un error inesperado. Intenta de nuevo.';
        }
      }
    });
  }

  login(): void {
    this.router.navigate(['/auth/login']);
  }
}
