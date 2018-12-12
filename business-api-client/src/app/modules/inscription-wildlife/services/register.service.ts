import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


import { Register } from '../model';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private userUrl = 'api/v1/users/';

  constructor(private http: HttpClient, ) { }

  register(user: Register) {
    return this.http.post(`${this.userUrl}`, user);
  };
}
