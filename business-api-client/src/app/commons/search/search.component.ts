import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { CampaignService } from '../../services/campaign.service';

import { OPTIONSCAMPAIGN } from '../model';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Format } from '../../campaign/model';

import { CustomValidator } from '../../utils/validators';

import { OptionSearch } from '../model';




@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  @Output()
  parametersSearch: EventEmitter<OptionSearch> = new EventEmitter();

  optionsCampaign = OPTIONSCAMPAIGN;
  searchForm: FormGroup;

  private avalaibleFormats: Format[];
  filteredFormats: Format[];

  submitted = false;

  constructor(
    private campaignService: CampaignService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit() {
    this.createForm();
    this.searchFormat();
  };

  createForm() {
    this.searchForm = this.formBuilder.group({
      inputFormat: ['', []],
      formats: ['', []],
      startDate: [, []],
      endDate: [, []],
      postalCode: [, [, Validators.pattern(CustomValidator.postalCodeValidator)]],
      city: ['', [, Validators.pattern(CustomValidator.cityValidator)]]
    });
  };

  searchFormat() {
    this.campaignService.searchFormat().subscribe(data => this.avalaibleFormats = data);
  };

  selectedOption(option) {
    if (option && option.length === 1) {
      return this.filteredFormats = this.avalaibleFormats.filter(format => format.name.includes(option[0].toUpperCase()));
    } else {
      return this.filteredFormats = this.avalaibleFormats;
    }
  };

  get formValues() {
    return this.searchForm.controls;
  };

  onSubmit() {
    this.submitted = true;
    if (this.searchForm.invalid) {
      return;
    }
    this.parametersSearch.emit(this.searchForm.value);
  };


}
