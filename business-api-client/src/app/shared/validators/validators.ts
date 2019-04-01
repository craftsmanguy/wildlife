import { AbstractControl } from '@angular/forms';

export class CustomValidator {
    static passwordValidator = '(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$&+,:@#|<>.^!-])(.{8,30})';
    static postalCodeValidator = '^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$';
    static numberValidator = '^(([1-2])|([1-2])|(9[0-8]))[0-9]{3}$';
    static loginValidator = '^[a-zA-Z0-9*-]*$';
    static cityValidator = /^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$/;

    static matchPassword = (control: AbstractControl): { [key: string]: boolean } => {
        const password = control.get('password');
        const confirmPassword = control.get('confirmPassword');

        if (password.pristine || confirmPassword.pristine) {
            return null;
        }
        control.markAsTouched();
        if (password.value === confirmPassword.value) {
            return null;
        }
        return {
            invalidMatchPassword: true
        };

    };
};
