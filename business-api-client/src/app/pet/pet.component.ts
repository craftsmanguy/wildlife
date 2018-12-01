import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { PetService } from '../services/pet.service';

import { Pet } from './model';


@Component({
  selector: 'pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css'],
  providers: [PetService]
})
export class PetComponent implements OnInit {

  @Input()
  action: string;

  @Input()
  pet: Pet;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private petService: PetService,
  ) { }

  ngOnInit() {
  };

  get(id: string) {
    this.petService.getPetById(id).subscribe(pet => this.pet = pet);
  };
}
