import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Advert } from '../advert-detail/index';

import { Format } from '../campaign/model';

@Injectable()
export class AdvertService {

  private advertUrl = 'api/v1/campaigns/';
  private formatUrl = 'api/v1/formats/';

  constructor(
    private http: HttpClient
  ) { }

  searchFormat() {
    return this.http.get<Format[]>(this.formatUrl);
  };

  searchAdvert() {
    return this.http.get(this.advertUrl);
  };

  getAdvertById(id: string) {
    return this.http.get<Advert>(this.advertUrl + id);
  };

  save(advert: Advert) {
    return this.http.post<Advert>(`${this.advertUrl}`, advert);
  };


}
