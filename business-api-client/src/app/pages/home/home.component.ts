import { Component, OnInit } from '@angular/core';

import { OptionSearch } from '../../commons/model';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  parametersSearch: OptionSearch;

  constructor() { }

  ngOnInit() {
  };

  onParametersSearch(search: OptionSearch) {
    this.parametersSearch = search;
  };

}
