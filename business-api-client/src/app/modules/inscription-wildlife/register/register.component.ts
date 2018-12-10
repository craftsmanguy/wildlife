import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Register } from '../model';
import { CustomValidator } from '../../../utils/validators';

import { RegisterService } from '../services/register.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  user: Register;

  constructor(
    private formBuilder: FormBuilder,
    private registerService: RegisterService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      pseudonym: ['', [Validators.required, Validators.pattern(CustomValidator.loginValidator)]],

      security: this.formBuilder.group({
        password: ['', [Validators.required, Validators.pattern(CustomValidator.passwordValidator)]],
        confirmPassword: ['', [Validators.required]],
      }, { validator: CustomValidator.matchPassword }),

      country: ['FRANCE', Validators.required],
      postalCode: ['', [Validators.required, Validators.pattern(CustomValidator.postalCodeValidator)]],
      city: ['', [Validators.required, Validators.pattern(CustomValidator.cityValidator)]]
    });
  };

  get formValues() {
    return this.registerForm.controls;
  };

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    this.user = this.transformFormToUserRegister(this.registerForm.value);
    this.registerService.register(this.user)
      .subscribe(
      data => {
        this.router.navigate(['/login']);
      });
  };

  private transformFormToUserRegister(value) {
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
}
