import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/services/authentication.service';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { CodeInputModule } from 'angular-code-input';

@Component({
  selector: 'app-activate-account',
  standalone: true,
  imports: [
    CodeInputModule,
    NgIf,
    ReactiveFormsModule
  ],
  templateUrl: './activate-account.component.html',
  styleUrls: ['./activate-account.component.scss']
})
export class ActivateAccountComponent {
  message = '';
  isSuccess = true;
  submitted = false;

  constructor(
    private router: Router,
    private authService: AuthenticationService,
  ) {}

  onCodeCompleted(token: string) {
    this.confirmAccount(token);
  }

  redirectToLogin() {
    this.router.navigate(['/auth/login']);
  }

  private confirmAccount(token: string) {
    this.authService.confirm({ token }).subscribe({
      next: () => {
        this.message = '¡Cuenta activada exitosamente! Ya puedes iniciar sesión.';
        this.submitted = true;
        this.isSuccess = true;
      },
      error: () => {
        this.message = 'La activación falló. Por favor verifica el código e inténtalo nuevamente.';
        this.submitted = true;
        this.isSuccess = false;
      }
    });
  }
}
