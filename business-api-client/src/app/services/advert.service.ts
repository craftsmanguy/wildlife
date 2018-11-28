import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Format, Campaign } from '../campaign/model';

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

  save(advert: Campaign) {
    return this.http.post<Campaign>(`${this.advertUrl}`, advert);
  };

  update(id: string, advert: Campaign) {
    return this.http.put<Campaign>(`${this.advertUrl+id}`, advert);
  };

  getById(id: string) {
    return this.http.get<Campaign>(this.advertUrl + id);
  };


}
