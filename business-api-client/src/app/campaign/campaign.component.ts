import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { switchMap, first } from 'rxjs/operators';
import { Observable } from 'rxjs';

import { AdvertService } from '../services/advert.service';

import { CustomValidator } from '../utils/validators';
import { OptionCampain, OPTIONSCAMPAIGN, Campaign, Format } from './model';

@Component({
  selector: 'app-campaign',
  templateUrl: './campaign.component.html',
  styleUrls: ['./campaign.component.css'],
  providers: [AdvertService]
})
export class CampaignComponent implements OnInit {

  advertId: string;

  campaign: Campaign;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private advertService: AdvertService,
  ) { }

  ngOnInit() {
    this.getAdvertById();
  };

  getAdvertById() {
    this.checkIdInUrlParam();
    if (this.advertId !== undefined) {
      this.advertService.getById(this.advertId).subscribe(advert => { this.campaign = advert });
    }
  };

  checkIdInUrlParam() {
    this.route.params.subscribe(params => {
      this.advertId = params['id'];
    });
  };

}
