import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';

import {Advert} from './advert';

@Injectable()
export class AdvertsService {

  private advertsUrl = 'api/v1/adverts';

  constructor(private http: HttpClient) {}

  getAdverts() {
    return this.http.get(this.advertsUrl);
  }

}
