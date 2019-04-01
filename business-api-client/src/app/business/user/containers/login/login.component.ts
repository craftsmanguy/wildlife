import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AuthenticationModel } from './model';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';
import { ConnectionService } from 'app/business/user/services/connection.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  titleContainer = ' Log In';

  loginForm: FormGroup;
  model: AuthenticationModel;
  returnUrl: string;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private connectionService: ConnectionService,
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  get formValues() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      return;
    }
    this.connectionService.login({ username: this.formValues.username.value, password: this.formValues.password.value })
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate([this.returnUrl]);
        });
  };

  logout() {
    this.connectionService.logout();
  }
}
