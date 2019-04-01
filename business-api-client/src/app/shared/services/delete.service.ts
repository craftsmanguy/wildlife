import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DeleteService {

  private contextRootUrl = 'api/v1/';

  constructor(
    private http: HttpClient
  ) { }

  delete(uri: string, id: string) {
    return this.http.delete(`${this.contextRootUrl}` + uri + '/' + id);
  };
}
