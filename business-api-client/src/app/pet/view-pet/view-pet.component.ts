import { Component, OnInit, Input } from '@angular/core';
import { Pet } from '../model';


@Component({
  selector: 'view-pet',
  templateUrl: './view-pet.component.html',
  styleUrls: ['./view-pet.component.css']
})
export class ViewPetComponent implements OnInit {

  @Input()
  pet: Pet;

  constructor() { }

  ngOnInit() {
  }

}
