import { Component, Input, Output, EventEmitter } from '@angular/core';

import { UserAction } from 'app/business/user/models/profil.model';
import { Campaign } from '../../models/campaign';


@Component({
  selector: 'app-quick-view-campaign',
  templateUrl: './quick-view-campaign.component.html',
  styleUrls: ['./quick-view-campaign.component.css']
})
export class QuickViewCampaignComponent {

  @Input()
  campaign: Campaign;

  @Output()
  userAction: EventEmitter<UserAction> = new EventEmitter();

  constructor() { }

  moreInformation(id: string) {
    this.userAction.emit({ action: 'VIEW_DETAIL_CAMPAIGN', id: id });
  };
}
