import { Component, OnChanges, Input } from '@angular/core';
import { Pet } from '../../models/model';
@Component({
  selector: 'app-view-pet',
  templateUrl: './view-pet.component.html',
  styleUrls: ['./view-pet.component.css']
})
export class ViewPetComponent implements OnChanges {

  @Input()
  pet: Pet;

  constructor(
  ) { }

  ngOnChanges() {
  }
}
