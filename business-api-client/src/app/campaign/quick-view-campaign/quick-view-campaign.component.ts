import { Component, Input } from '@angular/core';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { Campaign } from '../model';

@Component({
  selector: 'app-quick-view-campaign',
  templateUrl: './quick-view-campaign.component.html',
  styleUrls: ['./quick-view-campaign.component.css']
})
export class QuickViewCampaignComponent {

  @Input()
  campaign: Campaign;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
  ) { }


  redirectForCampaignDetail(id) {
    const urlCampaignById: string = this.router.url + '/';
    this.router.navigate(['/campaigns', id]);
  };


}
