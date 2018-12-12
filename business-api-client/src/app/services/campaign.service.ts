import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Format, Campaign } from '../campaign/model';

@Injectable()
export class CampaignService {

  private campaignUrl = 'api/v1/campaigns/';
  private formatUrl = 'api/v1/formats/';

  constructor(
    private http: HttpClient
  ) { }

  searchFormat() {
    return this.http.get<Format[]>(this.formatUrl);
  };

  search() {
    return this.http.get<Campaign[]>(this.campaignUrl);
  };

  save(campaign: Campaign) {
    return this.http.post<Campaign>(`${this.campaignUrl}`, campaign);
  };

  update(id: string, campaign: Campaign) {
    return this.http.put<Campaign>(`${this.campaignUrl + id}`, campaign);
  };

  getById(id: string) {
    return this.http.get<Campaign>(this.campaignUrl + id);
  };


}
