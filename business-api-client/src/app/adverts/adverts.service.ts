import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Advert } from '../advert-detail/index';

@Injectable()
export class AdvertsService {

  private advertsUrl = 'api/v1/campaigns/';

  constructor(private http: HttpClient) { }

  getAdverts() {
    return this.http.get(this.advertsUrl);
  };

  getAdvertById(id: string) {
    return this.http.get<Advert>(this.advertsUrl + id);
  }

}
