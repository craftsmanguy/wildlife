import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';

import {Router} from '@angular/router';

import {ActivatedRoute, ParamMap} from '@angular/router';


@Component({
  selector: 'app-pets',
  templateUrl: './notfound.component.html',
  styleUrls: ['./notfound.component.css']
})
export class NotFoundComponent {

  constructor(
    private location: Location,
    private router: Router,
    private route: ActivatedRoute) {}



}
