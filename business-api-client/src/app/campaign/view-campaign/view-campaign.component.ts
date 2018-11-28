import { Component, OnInit, Input } from '@angular/core';

import { Campaign } from '../model';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { AdvertService } from '../../services/advert.service';

@Component({
  selector: 'view-campaign',
  templateUrl: './view-campaign.component.html',
  styleUrls: ['./view-campaign.component.css'],
  providers: [AdvertService]
})
export class ViewCampaignComponent implements OnInit {

  @Input()
  advert: Campaign;
  advertId: string;
  fromUrl = true;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private advertService: AdvertService
  ) { }

  ngOnInit() {
    this.getAdvertById();
  };

  getAdvertById() {
    this.checkIdInUrlParam();
    if (this.advertId !== undefined) {
      this.advertService.getById(this.advertId).subscribe(advert => { this.advert = advert });
      this.fromUrl = false;
    }
  };

  checkIdInUrlParam() {
    this.route.params.subscribe(params => {
      this.advertId = params['id'];
    });
  };

  redirectForAdvertDetail(id) {
    const urlAdvertById: string = this.router.url + '/';
    this.router.navigate([urlAdvertById, id]);
  };

}
