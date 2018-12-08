import { Component, OnChanges, Input, Output, EventEmitter } from '@angular/core';

import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { switchMap, first } from 'rxjs/operators';
import { Observable } from 'rxjs';

import { CampaignService } from '../../services/campaign.service';

import { CustomValidator } from '../../utils/validators';
import { Campaign, Format, OPTIONSCAMPAIGN } from '../model';

@Component({
  selector: 'app-update-campaign',
  templateUrl: './update-campaign.component.html',
  styleUrls: ['./update-campaign.component.css'],
  providers: [CampaignService]
})
export class UpdateCampaignComponent implements OnChanges {

  @Input()
  campaign: Campaign;

  @Output()
  update: EventEmitter<Campaign> = new EventEmitter();

  private avalaibleFormats: Format[];
  optionsCampaign = OPTIONSCAMPAIGN;

  campaignForm: FormGroup;
  submitted = false;
  filteredFormats: Format[];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private campaignService: CampaignService,
  ) { }

  ngOnChanges() {
    if (this.campaign !== undefined) {
      this.filteredFormats = this.campaign.formats;
    }
    this.searchFormat();
    this.createForm();
  };

  createForm() {
    this.campaignForm = this.formBuilder.group({
      inputFormat: [this.campaign.formats[0].name],
      title: [this.campaign.title, [Validators.required]],
      startDate: [new Date(this.campaign.startDate), [Validators.required]],
      endDate: [new Date(this.campaign.endDate), [Validators.required]],
      formats: [this.campaign.formats, [Validators.required]],
      description: [this.campaign.description]
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
    this.update.emit(this.campaign);
  };

  private mappingFormToCampaign() {
    this.campaign.title = this.campaignForm.value.title;
    this.campaign.description = this.campaignForm.value.description;
    this.campaign.startDate = this.campaignForm.value.startDate;
    this.campaign.endDate = this.campaignForm.value.endDate;
    this.campaign.formats = this.campaignForm.value.formats;
  };

}
