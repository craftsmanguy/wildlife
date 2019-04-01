import { Component, OnInit, Input } from '@angular/core';
import { Topic } from 'app/shared/model';


@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  checked = false;
  indeterminate = false;

  @Input()
  listingFormat: Topic;

  constructor() { }

  ngOnInit() {
  }

}
