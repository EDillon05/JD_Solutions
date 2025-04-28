import {Component} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/services/authentication.service";
import {RegisterRequest} from "../../services/models/register-request";

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {

  registerRequest: RegisterRequest = {email: "", name: "", lastName1: "", lastName2: "", password: ""};
  errorMsg: Array<string> = [];

  constructor(
    private authService: AuthenticationService,
    private router: Router,
  ) {
  }

  registerAccount() {
    this.errorMsg = [];
    this.authService.registerUser({
      body: this.registerRequest
    }).subscribe({
      next: () => {
        this.router.navigate(['activate-account']);
      },
    error: (err) => {
      if (err.error.validationErrors) {
        this.errorMsg = err.error.validationErrors;
      } else {
        this.errorMsg.push(err.error.error);
      }
    }
    });
  }

  login() {
    this.router.navigate(['login']);
  }
}
