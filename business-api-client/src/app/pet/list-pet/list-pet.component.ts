import { Component, OnInit } from '@angular/core';
import { PetService } from '../../services/pet.service';
import { Pet } from '../model';

@Component({
  selector: 'app-list-pet',
  templateUrl: './list-pet.component.html',
  styleUrls: ['./list-pet.component.css'],
  providers: [PetService]
})
export class ListPetComponent implements OnInit {

  pets: Pet[];

  constructor(private petService: PetService) { }

  ngOnInit() {
    this.getAll();
  };

  getAll() {
    this.petService.getAll().subscribe(results => { this.pets = results});
  };

}
