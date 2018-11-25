import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Register } from '../register/model';


@Injectable()
export class UserService {

  private userUrl = 'api/v1/users/';

  constructor(private http: HttpClient, ) { }

  register(user: Register) {
    return this.http.post(`${this.userUrl}`, user);
  };

  getProfilById(id: string) {
    return this.http.get<any>(`${this.userUrl}` + id);
  }
}
