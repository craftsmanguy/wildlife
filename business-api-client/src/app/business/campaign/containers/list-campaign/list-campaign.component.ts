import { Component, Input, Output, EventEmitter } from '@angular/core';

import { UserAction } from 'app/business/user/models/profil.model';
import { Campaign } from '../../models/campaign';

@Component({
  selector: 'app-list-campaign',
  templateUrl: './list-campaign.component.html',
  styleUrls: ['./list-campaign.component.css']
})
export class ListCampaignComponent {

  @Input()
  campaigns: Campaign[];

  @Output()
  userAction: EventEmitter<UserAction> = new EventEmitter();

  constructor() { }

  onUserAction(action: UserAction) {
    this.userAction.emit(action);
  }

}
