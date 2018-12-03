import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { switchMap, first } from 'rxjs/operators';

import { CampaignService } from '../../services/campaign.service';

import { CustomValidator } from '../../utils/validators';
import { OptionCampain, OPTIONSCAMPAIGN, Campaign, Format, AbstractCampaign } from '../model';

@Component({
  selector: 'app-add-campaign',
  templateUrl: './add-campaign.component.html',
  styleUrls: ['./add-campaign.component.css'],
  providers: [CampaignService]
})
export class AddCampaignComponent implements OnInit {

  @Output()
  actionAddSucceed: EventEmitter<AbstractCampaign> = new EventEmitter();

  private avalaibleFormats: Format[];
  optionsCampaign = OPTIONSCAMPAIGN;
  campaign = new Campaign;

  campaignForm: FormGroup;
  submitted = false;
  filteredFormats: Format[];


  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
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
    this.campaignService.save(this.campaign)
      .pipe(first())
      .subscribe(
      data => {
        this.actionAddSucceed.emit(this.mappingFormToAbstractCampaign(data));
        return data;
      });
  };

  private mappingFormToCampaign() {
    this.campaign.title = this.campaignForm.value.title;
    this.campaign.description = this.campaignForm.value.description;
    this.campaign.startDate = this.campaignForm.value.startDate;
    this.campaign.endDate = this.campaignForm.value.endDate;
    this.campaign.formats = this.campaignForm.value.formats;
  };


private mappingFormToAbstractCampaign(data: any) {
const minimalCampaign = new AbstractCampaign;
minimalCampaign.functionalIdentifier = data.functionalIdentifier;
minimalCampaign.title = data.title;
return minimalCampaign;
};


}
