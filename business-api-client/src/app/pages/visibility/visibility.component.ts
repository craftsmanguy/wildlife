import { Component, OnInit } from '@angular/core';

import { OptionSearch } from '../../commons/model';


@Component({
  selector: 'app-visibility',
  templateUrl: './visibility.component.html',
  styleUrls: ['./visibility.component.css']
})
export class VisibilityComponent implements OnInit {

  parametersSearch: OptionSearch;

  constructor() { }

  ngOnInit() {
  };

  onParametersSearch(search: OptionSearch) {
    this.parametersSearch = search;
  };

}
