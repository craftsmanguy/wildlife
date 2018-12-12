import { Component, Input } from '@angular/core';

import { Campaign } from '../model';

@Component({
  selector: 'app-view-campaign',
  templateUrl: './view-campaign.component.html',
  styleUrls: ['./view-campaign.component.css']
})
export class ViewCampaignComponent {

  @Input()
  campaign: Campaign;
  constructor() { }
}
