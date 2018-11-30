import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable()
export class AdminService {

  private checkUrl = 'api/v1/checks/token/';
  
    constructor(private http: HttpClient, ) { }
  
    isLoggedIn() {
      return this.http.get<boolean>(this.checkUrl);
    };
}
