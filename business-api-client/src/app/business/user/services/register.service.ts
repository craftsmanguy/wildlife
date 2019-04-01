import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Register } from '../models/user';



@Injectable()
export class RegisterService {

  private userUrl = 'api/v1/users/';

  constructor(private http: HttpClient, ) { }

  register(user: Register) {
    return this.http.post(`${this.userUrl}`, user);
  };
}
