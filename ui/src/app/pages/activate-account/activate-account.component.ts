import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {CodeInputModule} from "angular-code-input";
import {AuthenticationService} from "../../services/services/authentication.service";
import {NgIf} from "@angular/common";


@Component({
  selector: 'app-activate-account',
  standalone: true,
  imports: [
    CodeInputModule,
    NgIf
  ],
  templateUrl: './activate-account.component.html',
  styleUrl: './activate-account.component.scss'
})
export class ActivateAccountComponent {

  message = '';
  isSucces = true;
  submitted = false;

  constructor(
    private router: Router,
    private authService: AuthenticationService,
  ) {
  }

  onCodeCompleted(token: string) {
    this.confirmAccount(token);

  }

  redirectToLogin() {
    this.router.navigate(['/login']);
  }

  private confirmAccount(token: string) {
    this.authService.confirm({
      token
    }).subscribe({
      next: () => {
        this.message = 'Account activated successfully.\n You can now login.';
        this.submitted = true;
        this.isSucces = true;
      },
      error: () => {
        this.message = 'Account activation failed.\n Please try again.';
        this.submitted = true;
        this.isSucces = false;
      }
    });
  }
}
