import { Component, OnInit } from '@angular/core';

import { CampaignService } from '../../services/campaign.service';

import { Format } from '../../campaign/model';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomValidator } from '../../utils/validators';



@Component({
  selector: 'app-quick-search',
  templateUrl: './quick-search.component.html',
  styleUrls: ['./quick-search.component.css']
})
export class QuickSearchComponent implements OnInit {

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
      formats: ['', [Validators.required]],
      date: ['', []],
      postalCode: [, [Validators.required, Validators.pattern(CustomValidator.postalCodeValidator)]],
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
  };

}
