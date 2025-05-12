import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm: FormGroup;
  errorMsg: string = '';
  isLoading: boolean = false;

  constructor(
    private authService: AuthenticationService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  login(): void {
    this.errorMsg = '';
    this.isLoading = true;

    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      this.isLoading = false;
      return;
    }

    const formValue = this.loginForm.value;

    this.authService.loginUser({
      email: formValue.email,
      password: formValue.password
    }).subscribe({
      next: () => {
        this.isLoading = false;
        this.router.navigate(['/dashboard']); // ajusta la ruta según tu app
      },
      error: (err) => {
        this.isLoading = false;
        if (err.error?.message) {
          this.errorMsg = err.error.message;
        } else {
          this.errorMsg = 'Ocurrió un error inesperado. Intenta de nuevo.';
        }
      }
    });
  }

  goToRegister(): void {
    this.router.navigate(['/auth/register']);
  }
}
