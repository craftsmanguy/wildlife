import {Injectable} from '@angular/core';

import {Advert} from './advert';

import {Headers, Http, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';


import {NgXCookies} from 'ngx-cookies';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/catch';

@Injectable()
export class AdvertsService {

  private advertsUrl = 'api/v1/adverts';
  private campaignsUrl = 'api/campaigns';

  constructor(private http: Http) {}

  getAdverts(): Promise<Advert[]> {
    return this.http.get(this.advertsUrl)
      .toPromise()
      .then(response => response.json().data as Advert[])
      .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }


}
