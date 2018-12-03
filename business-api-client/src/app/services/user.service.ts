import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Register } from '../register/model';
import { User } from '../profil/model';


@Injectable({
  providedIn: 'root',
})
export class UserService {

  private userUrl = 'api/v1/users/';

  constructor(private http: HttpClient, ) { }

  register(user: Register) {
    return this.http.post(`${this.userUrl}`, user);
  };

  getCurrent() {
    return this.http.get<User>(`${this.userUrl}` + 'current');
  };

  getProfilById(id: string) {
    return this.http.get<any>(`${this.userUrl}` + id);
  };
}
