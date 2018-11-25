import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AlertService } from '../alert/alert.service';
import { UserService } from '../services/user.service';
import { Register } from './model';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { CustomValidator } from '../utils/validators';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  user: Register;

  transformFormToUserRegister(value) {
    const userToInsert = new Register();
    userToInsert.pseudonym = value.pseudonym;
    userToInsert.email = value.email;
    userToInsert.password = value.security.password;
    userToInsert.confirmPassword = value.security.confirmPassword;
    userToInsert.country = value.country;
    userToInsert.postalCode = value.postalCode;
    userToInsert.city = value.city;
    return userToInsert;
  };

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService,
    private alertService: AlertService
  ) { }

  get formValues() {
    return this.registerForm.controls;
  };

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      pseudonym: ['', [Validators.required, Validators.pattern(CustomValidator.loginValidator)]],

      security: this.formBuilder.group({
        password: ['', [Validators.required, Validators.pattern(CustomValidator.passwordValidator)]],
        confirmPassword: ['', [Validators.required]],
      }, { validator: CustomValidator.matchPassword }),

      country: ['FRANCE', Validators.required],
      postalCode: ['', [Validators.required, Validators.pattern(CustomValidator.numberValidator)]],
      city: ['', [Validators.required, Validators.pattern(CustomValidator.cityValidator)]]
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      console.log(this.registerForm.invalid);
      return;
    }
    this.user = this.transformFormToUserRegister(this.registerForm.value);
    this.userService.register(this.user)
      .pipe(first())
      .subscribe(
      data => {
        this.router.navigate(['/login']);
      },
      error => {
        this.alertService.error('Invalid login or password');
      });
  };


}
