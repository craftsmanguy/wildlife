import { Component, Inject, Input, Optional } from '@angular/core';


import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Campaign } from '../../models/campaign';



@Component({
  selector: 'app-view-campaign',
  templateUrl: './view-campaign.component.html',
  styleUrls: ['./view-campaign.component.css']
})
export class ViewCampaignComponent {

  @Input('campaign')
  campaign: Campaign;

  constructor(
    @Optional() public dialogRef: MatDialogRef<ViewCampaignComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: Campaign
  ) { }

  onNoClick() {
    this.dialogRef.close();
  }
}
