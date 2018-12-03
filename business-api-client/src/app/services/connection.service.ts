import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { AuthenticationModel } from '../connection/model';

import { map } from 'rxjs/operators';



@Injectable({
  providedIn: 'root',
})
export class ConnectionService {

  private loginUrl = 'api/v1/authenticate';
  information: Object;

  constructor(
    private http: HttpClient,
  ) { }

  login(credentials: AuthenticationModel) {
    return this.http.post(this.loginUrl, credentials);
  };

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
