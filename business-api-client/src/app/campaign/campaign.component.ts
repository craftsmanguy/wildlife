import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { switchMap, first } from 'rxjs/operators';
import { Observable } from 'rxjs';

import { CampaignService } from '../services/campaign.service';

import { CustomValidator } from '../utils/validators';
import { OptionCampain, OPTIONSCAMPAIGN, Campaign, Format } from './model';

@Component({
  selector: 'app-campaign',
  templateUrl: './campaign.component.html',
  styleUrls: ['./campaign.component.css'],
  providers: [CampaignService]
})
export class CampaignComponent implements OnInit {

  campaignId: string;

  @Input()
  campaign: Campaign;

  @Input()
  action: string;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private campaignService: CampaignService,
  ) { }

  ngOnInit() {
    this.getById();
  };

  getById() {
    this.checkIdInUrlParam();
    if (this.campaignId !== undefined) {
      this.campaignService.getById(this.campaignId).subscribe(campaign => {
        this.campaign = campaign
      });
    }
  };

  checkIdInUrlParam() {
    this.route.params.subscribe(params => {
      this.campaignId = params['id'];
    });
  };

}
