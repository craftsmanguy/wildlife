import { Component, OnInit, Input } from '@angular/core';
import { CampaignService } from '../../services/campaign.service';

import { Campaign } from '../model';


@Component({
  selector: 'app-list-campaign',
  templateUrl: './list-campaign.component.html',
  styleUrls: ['./list-campaign.component.css']
})
export class ListCampaignComponent implements OnInit {

  @Input()
  optionsSearch: any;

  campaigns: Campaign[];

  constructor(
    private campaignService: CampaignService,
  ) { }

  ngOnInit(): void {
    this.getCampaigns();
  };

  getCampaigns(): void {
    this.campaignService.search().subscribe(data => this.campaigns = data);
  };

}
