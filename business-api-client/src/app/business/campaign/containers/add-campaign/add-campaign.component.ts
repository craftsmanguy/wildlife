import { Component, OnInit, OnDestroy } from '@angular/core';
import { Campaign, Format } from '../../models/campaign';
import { CampaignService } from '../../services/campaign.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-add-campaign',
  templateUrl: './add-campaign.component.html',
  styleUrls: ['./add-campaign.component.css']
})
export class AddCampaignComponent implements OnInit, OnDestroy {

  titleContainer = ' Add advert';

  avalaibleFormats: Format[];
  campaign = new Campaign;
  filteredFormats: Format[];

  campaignAddition: Subscription;


  constructor(
    private campaignService: CampaignService,
  ) { }

  ngOnInit() {
    this.searchFormat();
  };


  searchFormat() {
    this.campaignAddition = this.campaignService.searchFormat().subscribe(data => this.avalaibleFormats = data);
  };


  onSubmitForm(campaign: Campaign) {
    this.campaignService.save(campaign)
      .subscribe(
        data => {

        });
  };

  ngOnDestroy() {
    if (this.campaignAddition) {
      this.campaignAddition.unsubscribe();
    }
  }

}
