import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Register } from '../../models/user';
import { RegisterService } from '../../services/register.service';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  titleContainer = ' Register';

  constructor(
    private registerService: RegisterService,
    private router: Router,
  ) { }

  ngOnInit() {
  }

  onSubmitted(user: Register) {
    if (user) {
      this.registerService.register(user)
        .subscribe(
          data => {
            this.router.navigate(['/login']);
          });
    }
  };
}
