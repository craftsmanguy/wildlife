import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticationModel } from '../containers/login/model';


@Injectable()
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
    localStorage.removeItem('currentUser');
  }
}
