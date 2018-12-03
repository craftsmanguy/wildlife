import { Component, OnInit, OnChanges, Input } from '@angular/core';
import { Pet } from '../model';
import { PetService } from '../../services/pet.service';


@Component({
  selector: 'app-view-pet',
  templateUrl: './view-pet.component.html',
  styleUrls: ['./view-pet.component.css']
})
export class ViewPetComponent implements OnInit, OnChanges {

  @Input()
  id: string;

  pet: Pet;

  constructor(
    private petService: PetService,
  ) { }

  ngOnInit() {
    this.get(this.id);
  };

  ngOnChanges() {
    this.get(this.id);
  }

  get(id: string) {
    this.petService.getPetById(id).subscribe(pet => this.pet = pet);
  };

}
