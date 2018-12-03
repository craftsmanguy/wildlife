import { Component, OnInit, Input } from '@angular/core';

import { Location } from '@angular/common';
import { DatePipe } from '@angular/common';

import 'rxjs/add/operator/switchMap';
import { CampaignService } from '../../services/campaign.service';
import { Router } from '@angular/router';

import { ActivatedRoute, ParamMap } from '@angular/router';

import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-campaign',
  templateUrl: './list-campaign.component.html',
  styleUrls: ['./list-campaign.component.css']
})
export class ListCampaignComponent implements OnInit {
  campaigns: Object;

  constructor(
    private location: Location,
    private router: Router,
    private campaignService: CampaignService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getCampaigns();
  };

  getCampaigns(): void {
    this.campaignService.search().subscribe(data => this.campaigns = data);
  };

}
