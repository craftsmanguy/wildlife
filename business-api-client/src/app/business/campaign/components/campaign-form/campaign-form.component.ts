import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Campaign, Format, OPTIONSCAMPAIGN, OptionCampain } from '../../models/campaign';

@Component({
  selector: 'app-campaign-form',
  templateUrl: './campaign-form.component.html',
  styleUrls: ['./campaign-form.component.css']
})
export class CampaignFormComponent implements OnInit {

  @Output()
  submitForm: EventEmitter<any> = new EventEmitter();

  @Input()
  avalaibleFormats: Format[];

  @Input()
  campaign: Campaign;

  optionsCampaign = OPTIONSCAMPAIGN;
  filteredFormats: Format[];

  campaignForm: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.createForm();
  }

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

  createForm2() {
    this.campaignForm = this.formBuilder.group({
      inputFormat: [this.campaign.formats[0].name],
      title: [this.campaign.title, [Validators.required]],
      startDate: [new Date(this.campaign.startDate), [Validators.required]],
      endDate: [new Date(this.campaign.endDate), [Validators.required]],
      formats: [this.campaign.formats, [Validators.required]],
      description: [this.campaign.description]
    });
  };

  get formValues() {
    return this.campaignForm.controls;
  };

  selected(option) {
    return this.filteredFormats = this.avalaibleFormats.filter(format => format.name.includes(option.toUpperCase()));
  }

  onSubmit() {
    this.submitted = true;
    if (this.campaignForm.invalid) {
      return;
    }
    const campaign = this.mappingFormToCampaign(this.campaignForm.value);
    this.submitForm.emit(campaign);
  };

  private mappingFormToCampaign(value: any) {
    const campaign: Campaign = new Campaign();
    campaign.title = value.title;
    campaign.description = value.description;
    campaign.startDate = value.startDate;
    campaign.endDate = value.endDate;
    campaign.formats = value.formats;
    return campaign;
  };


}
