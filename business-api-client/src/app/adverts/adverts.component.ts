import { Component, OnInit, Input } from '@angular/core';

import { Location } from '@angular/common';
import { DatePipe } from '@angular/common';

import 'rxjs/add/operator/switchMap';
import { AdvertsService } from './adverts.service';
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
    private advertsService: AdvertsService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getAdverts();
  };

  getAdverts(): void {
    this.advertsService.getAdverts().subscribe(data => this.adverts = data);
  };

}
