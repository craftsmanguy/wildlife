import { Component, OnInit } from '@angular/core';

import { OptionSearch } from '../../commons/model';

import { CampaignService } from '../../services/campaign.service';

import { Campaign } from '../../campaign/model';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  campaigns: Campaign[];
  parametersSearch: OptionSearch;

  constructor(
    private campaignService: CampaignService,
  ) { }

  ngOnInit() {
    this.getCampaigns();
  };

  onParametersSearch(search: OptionSearch) {
    this.parametersSearch = search;
  };

  getCampaigns() {
    this.campaignService.search().subscribe(data => this.campaigns = data);
  };

}
