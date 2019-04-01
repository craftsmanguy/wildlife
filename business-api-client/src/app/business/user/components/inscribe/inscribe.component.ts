import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomValidator } from 'app/shared/validators/validators';
import { Register } from '../../models/user';

@Component({
  selector: 'app-inscribe',
  templateUrl: './inscribe.component.html',
  styleUrls: ['./inscribe.component.css']
})
export class InscribeComponent implements OnInit {

  @Output()
  submitForm: EventEmitter<any> = new EventEmitter();

  registerForm: FormGroup;
  submitted = false;


  constructor(
    private formBuilder: FormBuilder
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

  click() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    const user = this.transformFormToUserRegister(this.registerForm.value);
    this.submitForm.emit(user);
  }

  private transformFormToUserRegister(value: any) {
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
