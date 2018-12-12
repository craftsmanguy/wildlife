import { Component, Input, Output, EventEmitter } from '@angular/core';

import { Campaign } from '../model';
import { UserAction } from '../../profil/model';


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
