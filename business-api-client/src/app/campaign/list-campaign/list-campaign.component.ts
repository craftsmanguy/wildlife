import { Component, OnInit, Input } from '@angular/core';

import { Campaign } from '../model';


@Component({
  selector: 'app-list-campaign',
  templateUrl: './list-campaign.component.html',
  styleUrls: ['./list-campaign.component.css']
})
export class ListCampaignComponent {

  @Input()
  campaigns: Campaign[];

  constructor() { }

}
