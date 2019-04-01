import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';



@Injectable({
  providedIn: 'root',
})
export class AdminService {

  private checkUrl = 'api/v1/checks/token/';

  constructor(private http: HttpClient, ) { }

  isLoggedIn() {
    return this.http.get<boolean>(this.checkUrl);
  };
}
