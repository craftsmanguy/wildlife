import { Component, OnInit, Input } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AlertService } from '../alert/alert.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { CustomValidator } from '../utils/validators';

import { switchMap } from 'rxjs/operators';

import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';

import { AdvertService } from '../services/advert.service';

import { OPTIONSCAMPAIGN, Campaign, Format } from './model';

@Component({
  selector: 'app-campaign',
  templateUrl: './campaign.component.html',
  styleUrls: ['./campaign.component.css']
})
export class CampaignComponent implements OnInit {

  optionsCampaign = OPTIONSCAMPAIGN;

  private avalaibleFormats: Format[];

  campaignForm: FormGroup;
  submitted = false;

  filteredFormats: Format[];

  @Input()
  campaign: Campaign;



  filteredRaces: any;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private advertService: AdvertService,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.searchFormat();

    this.campaignForm = this.formBuilder.group({
      inputFormat: ['', [Validators.required]],
      title: ['', [Validators.required]],
      startDate: [, [Validators.required]],
      endDate: [, [Validators.required]],
      formats: ['', [Validators.required]],
      description: ['']
    });
  };

  searchFormat() {
    this.advertService.searchFormat().subscribe (data => this.avalaibleFormats = data);
  };

  searchFeature(filter: { name: string } = { name: '' }, page = 1) {
    return this.avalaibleFormats.filter (format => {
      return format.feature.includes(filter.name.toUpperCase())});
  };

  get formValues() {
    return this.campaignForm.controls;
  };

  selectedOption(option) {
    this.filteredFormats = this.avalaibleFormats.filter (format => {
      return format.name.includes(option.toUpperCase())});
    console.log(this.filteredFormats);
  };

  onSubmit() {
    this.submitted = true;

    if (this.campaignForm.invalid) {
      return;
    }
    this.advertService.save(this.campaignForm.value)
      .pipe(first())
      .subscribe(
      data => {
        this.router.navigate(['/login']);
      },
      error => {
        this.alertService.error('Invalid add pet');
      });
  };


}
