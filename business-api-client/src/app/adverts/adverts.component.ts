import { Component, OnInit, Input } from '@angular/core';

import { Location } from '@angular/common';
import { DatePipe } from '@angular/common';

import 'rxjs/add/operator/switchMap';


import { Advert } from './advert';
import { AdvertsService } from './adverts.service';
import { Router } from '@angular/router';

import { ActivatedRoute, ParamMap } from '@angular/router';


@Component({
  selector: 'app-adverts',
  templateUrl: './adverts.component.html',
  styleUrls: ['./adverts.component.css']
})
export class AdvertsComponent implements OnInit {
  advert: Advert;
  //  campaign: Campagne;
  adverts: Advert[] = [];
  loading = false;

  constructor(
    private location: Location,
    private router: Router,
    private advertsService: AdvertsService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getAdverts();
  };

  getAdverts(): void {
    this.advertsService.getAdverts().then(adverts => this.adverts = adverts);
  };

}
