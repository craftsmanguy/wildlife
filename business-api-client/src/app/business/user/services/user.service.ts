import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'app/business/user/models/profil.model';



@Injectable({
  providedIn: 'root',
})
export class UserService {

  private userUrl = 'api/v1/users/';

  constructor(private http: HttpClient, ) { }

  getCurrent() {
    return this.http.get<User>(`${this.userUrl}` + 'current');
  };

  getProfilById(id: string) {
    return this.http.get<any>(`${this.userUrl}` + id);
  };
}
