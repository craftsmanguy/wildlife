import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private userUrl = 'api/v1/users/';
  
    constructor(private http: HttpClient, ) { }
  
    getProfilById(id: string) {
      return this.http.get<any>(`${this.userUrl}` + id);
    };
}
