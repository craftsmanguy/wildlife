import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-default-card',
  templateUrl: './default-card.component.html',
  styleUrls: ['./default-card.component.css']
})
export class DefaultCardComponent implements OnInit {

  @Input()
  titleCard: string;

  constructor() { }

  ngOnInit() {
  }

}
