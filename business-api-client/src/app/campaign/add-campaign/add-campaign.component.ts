import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ParamMap } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { switchMap, first } from 'rxjs/operators';


import { CustomValidator } from '../../utils/validators';
import { Campaign, Format, OPTIONSCAMPAIGN } from '../model';

import { CampaignService } from '../../services/campaign.service';


@Component({
  selector: 'app-add-campaign',
  templateUrl: './add-campaign.component.html',
  styleUrls: ['./add-campaign.component.css']
})
export class AddCampaignComponent implements OnInit {

  @Output()
  add: EventEmitter<Campaign> = new EventEmitter();

  private avalaibleFormats: Format[];
  optionsCampaign = OPTIONSCAMPAIGN;
  campaign = new Campaign;

  campaignForm: FormGroup;
  submitted = false;
  filteredFormats: Format[];


  constructor(
    private formBuilder: FormBuilder,
    private campaignService: CampaignService,
  ) { }

  ngOnInit() {
    this.searchFormat();
    this.createForm();
  };

  createForm() {
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
    this.campaignService.searchFormat().subscribe(data => this.avalaibleFormats = data);
  };

  selectedOption(option) {
    return this.filteredFormats = this.avalaibleFormats.filter(format => format.name.includes(option.toUpperCase()));
  };

  get formValues() {
    return this.campaignForm.controls;
  };

  onSubmit() {
    this.submitted = true;
    if (this.campaignForm.invalid) {
      return;
    }
    this.mappingFormToCampaign();
    this.add.emit(this.campaign);
  };

  private mappingFormToCampaign() {
    this.campaign.title = this.campaignForm.value.title;
    this.campaign.description = this.campaignForm.value.description;
    this.campaign.startDate = this.campaignForm.value.startDate;
    this.campaign.endDate = this.campaignForm.value.endDate;
    this.campaign.formats = this.campaignForm.value.formats;
  };


}
