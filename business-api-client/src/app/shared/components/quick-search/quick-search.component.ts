import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OptionSearch } from 'app/shared/model';
import { CampaignService } from 'app/business/campaign/services/campaign.service';
import { Format } from 'app/business/campaign/models/campaign';
import { CustomValidator } from 'app/shared/validators/validators';


@Component({
  selector: 'app-quick-search',
  templateUrl: './quick-search.component.html',
  styleUrls: ['./quick-search.component.css']
})
export class QuickSearchComponent implements OnInit {

  @Output()
  parametersSearch: EventEmitter<OptionSearch> = new EventEmitter();

  quickSearchForm: FormGroup;
  submitted = false;

  avalaibleFormats: Format[];

  constructor(
    private campaignService: CampaignService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit() {
    this.searchFormat();
    this.createForm();
  };

  createForm() {
    this.quickSearchForm = this.formBuilder.group({
      formats: ['', []],
      startDate: ['', []],
      postalCode: [, [Validators.pattern(CustomValidator.postalCodeValidator)]],
    });
  };

  searchFormat() {
    this.campaignService.searchFormat().subscribe(data => this.avalaibleFormats = data);
  };

  get formValues() {
    return this.quickSearchForm.controls;
  };

  onSubmit() {
    this.submitted = true;
    if (this.quickSearchForm.invalid) {
      return;
    }
    this.parametersSearch.emit(this.quickSearchForm.value);
  };

}
