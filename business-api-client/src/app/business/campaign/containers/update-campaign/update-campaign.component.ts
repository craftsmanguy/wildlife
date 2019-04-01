import { Component, EventEmitter, Input, OnChanges, Output, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CampaignService } from '../../services/campaign.service';
import { Campaign, Format, OPTIONSCAMPAIGN } from '../../models/campaign';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-update-campaign',
  templateUrl: './update-campaign.component.html',
  styleUrls: ['./update-campaign.component.css']
})
export class UpdateCampaignComponent implements OnChanges, OnDestroy {

  @Input()
  campaign: Campaign;

  @Output()
  update: EventEmitter<Campaign> = new EventEmitter();

  optionsCampaign = OPTIONSCAMPAIGN;
  avalaibleFormats: Format[];

  filteredFormats: Format[];

  campaignUpdate: Subscription;

  constructor(
    private campaignService: CampaignService,
  ) { }

  ngOnChanges() {
    if (this.campaign !== undefined) {
      this.filteredFormats = this.campaign.formats;
    }
    this.searchFormat();
  };

  searchFormat() {
    this.campaignUpdate = this.campaignService.searchFormat().subscribe(data => this.avalaibleFormats = data);
  };

  ngOnDestroy() {
    if (this.campaignUpdate) {
      this.campaignUpdate.unsubscribe();
    }
  }

}
