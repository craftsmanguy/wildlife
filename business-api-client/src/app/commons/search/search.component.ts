import { Component, OnInit } from '@angular/core';

import { CampaignService } from '../../services/campaign.service';

import { OPTIONSCAMPAIGN } from '../../shared/model';

import { Format } from '../../campaign/model';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  optionsCampaign = OPTIONSCAMPAIGN;

  private avalaibleFormats: Format[];
  favoriteSeason: string;
  filteredFormats: Format[];

  constructor(
    private campaignService: CampaignService,
  ) { }

  ngOnInit() {
    this.searchFormat();
  }

  searchFormat() {
    this.campaignService.searchFormat().subscribe(data => this.avalaibleFormats = data);
  };

  selectedOption(option) {
    return this.filteredFormats = this.avalaibleFormats.filter(format => format.name.includes(option.toUpperCase()));
  };


}
