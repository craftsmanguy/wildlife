import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OptionSearch } from 'app/shared/model';
import { OPTIONSCAMPAIGN, Format } from 'app/business/campaign/models/campaign';
import { CampaignService } from 'app/business/campaign/services/campaign.service';
import { CustomValidator } from 'app/shared/validators/validators';




@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private _parametersSearch: OptionSearch;

  @Output()
  parametersSearchChange: EventEmitter<OptionSearch> = new EventEmitter();

  @Input()
  set parametersSearch(value: OptionSearch) {
    this._parametersSearch = value;
    console.log(JSON.stringify(value));
  };

  get parametersSearch(): OptionSearch {
    return this._parametersSearch;
  }

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
      inputFormat: [this._parametersSearch.inputFormat, []],
      formats: [this._parametersSearch.formats, []],
      startDate: [new Date(this._parametersSearch.startDate), []],
      endDate: [, []],
      postalCode: [this._parametersSearch.postalCode, [, Validators.pattern(CustomValidator.postalCodeValidator)]],
      city: [this._parametersSearch.city, [, Validators.pattern(CustomValidator.cityValidator)]]
    });
  };

  searchFormat() {
    this.campaignService.searchFormat().subscribe(data => {
      this.avalaibleFormats = data,
        this.filteredFormats = this.avalaibleFormats
    });
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
    this.parametersSearchChange.emit(this.searchForm.value);
  };


}
