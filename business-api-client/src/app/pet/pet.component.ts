import { Component, OnInit, Input } from '@angular/core';

import { PetService } from '../services/pet.service';
import { Pet, GENDERS, Race } from './model';

import { first } from 'rxjs/operators';

import { AlertService } from '../alert/alert.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { CustomValidator } from '../utils/validators';

import { switchMap } from 'rxjs/operators';

import { Observable } from 'rxjs';


@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css'],
  providers: [PetService]
})
export class PetComponent implements OnInit {

  filteredRaces: Observable<Race[]>;

  genders = GENDERS;
  petForm: FormGroup;
  submitted = false;

  readPet: Pet;

  @Input()
  addPet: Pet;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private petService: PetService,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.petForm = this.formBuilder.group({
      functionalIdentifier: [''],
      gender: [this.genders[0].label, [Validators.required]],
      name: ['', [Validators.required]],
      race: ['', [Validators.required]],
      birth: ['', [Validators.required, Validators.pattern(CustomValidator.numberValidator)]],
      lof: [false, [Validators.required]],
      description: ['']
    });

    this.filteredRaces = this.petForm
    .get('race')
    .valueChanges
    .pipe(
    switchMap(value => this.petService.searchRaceByName({ name: value }, 1))
    );
  };

  displayFn(race: Race) {
    if (race) { return race.name; }
  };

  get formValues() {
    return this.petForm.controls;
  };

  get(id: string) {
    this.petService.getPetById(id).subscribe(pet => this.readPet = pet);
  };

  onSubmit() {
    this.submitted = true;

    if (this.petForm.invalid) {
      return;
    }
    this.petService.save(this.petForm.value)
      .pipe(first())
      .subscribe(
      data => {
        this.router.navigate(['/login']);
      },
      error => {
        this.alertService.error('Invalid add pet');
      });
  };

}
