import { Component, OnInit, Input } from '@angular/core';

import { Location } from '@angular/common';
import { DatePipe } from '@angular/common';

import 'rxjs/add/operator/switchMap';
import { AdvertService } from '../services/advert.service';
import { Router } from '@angular/router';

import { ActivatedRoute, ParamMap } from '@angular/router';

import { Observable } from 'rxjs';

@Component({
  selector: 'app-adverts',
  templateUrl: './adverts.component.html',
  styleUrls: ['./adverts.component.css']
})
export class AdvertsComponent implements OnInit {
  adverts: Object;

  constructor(
    private location: Location,
    private router: Router,
    private advertService: AdvertService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getAdverts();
  };

  getAdverts(): void {
    this.advertService.searchAdvert().subscribe(data => this.adverts = data);
  };

}
