import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { switchMap, first } from 'rxjs/operators';

import { AdvertService } from '../../services/advert.service';

import { CustomValidator } from '../../utils/validators';
import { OptionCampain, OPTIONSCAMPAIGN, Campaign, Format } from '../model';

@Component({
  selector: 'add-campaign',
  templateUrl: './add-campaign.component.html',
  styleUrls: ['./add-campaign.component.css'],
  providers: [AdvertService]
})
export class AddCampaignComponent implements OnInit {

  private avalaibleFormats: Format[];
  optionsCampaign = OPTIONSCAMPAIGN;
  advert = new Campaign();

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
    this.advertService.save(this.advert)
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
