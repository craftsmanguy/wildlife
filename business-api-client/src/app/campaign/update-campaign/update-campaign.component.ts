import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { switchMap, first } from 'rxjs/operators';
import { Observable } from 'rxjs';

import { AdvertService } from '../../services/advert.service';

import { CustomValidator } from '../../utils/validators';
import { OptionCampain, OPTIONSCAMPAIGN, Campaign, Format } from '../model';


@Component({
  selector: 'update-campaign',
  templateUrl: './update-campaign.component.html',
  styleUrls: ['./update-campaign.component.css'],
  providers: [AdvertService]
})
export class UpdateCampaignComponent implements OnInit {

  @Input()
  advert: Campaign;

  private avalaibleFormats: Format[];
  optionsCampaign = OPTIONSCAMPAIGN;

  campaignForm: FormGroup;
  submitted = false;
  filteredFormats: Format[];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private advertService: AdvertService,
  ) { }

  ngOnInit() {
    this.filteredFormats = this.advert.formats;
    this.searchFormat();
    this.createForm();
  };

  createForm() {
    this.campaignForm = this.formBuilder.group({
      inputFormat: [this.advert.formats[0].name],
      title: [this.advert.title, [Validators.required]],
      startDate: [new Date(this.advert.startDate), [Validators.required]],
      endDate: [new Date(this.advert.endDate), [Validators.required]],
      formats: [this.advert.formats, [Validators.required]],
      description: [this.advert.description]
    });
  };

  searchFormat() {
    this.advertService.searchFormat().subscribe(data => this.avalaibleFormats = data);
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
    this.mappingFormToAvert();
    this.advertService.update(this.advert.functionalIdentifier, this.advert)
      .pipe(first())
      .subscribe(
      data => {
        this.router.navigate(['/login']);
      });
  };

  private mappingFormToAvert() {
    this.advert.title = this.campaignForm.value.title;
    this.advert.description = this.campaignForm.value.description;
    this.advert.startDate = this.campaignForm.value.startDate;
    this.advert.endDate = this.campaignForm.value.endDate;
    this.advert.formats = this.campaignForm.value.formats;
  };

}
