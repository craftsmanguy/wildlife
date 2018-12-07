import { Component, Input } from '@angular/core';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { Campaign } from '../model';

@Component({
  selector: 'app-view-campaign',
  templateUrl: './view-campaign.component.html',
  styleUrls: ['./view-campaign.component.css']
})
export class ViewCampaignComponent {

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
