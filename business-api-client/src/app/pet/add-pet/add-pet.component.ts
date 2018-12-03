import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { PetService } from '../../services/pet.service';
import { Pet, AbstractPet, GENDERS, Race } from '../model';

import { first } from 'rxjs/operators';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { CustomValidator } from '../../utils/validators';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent implements OnInit {

  @Output()
  actionAddSucceed: EventEmitter<AbstractPet> = new EventEmitter();

  filteredRaces: Observable<Race[]>;

  genders = GENDERS;
  petForm: FormGroup;
  submitted = false;
  pet: Pet;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private petService: PetService,
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
    this.petService.getPetById(id).subscribe(pet => this.pet = pet);
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
        this.actionAddSucceed.emit(this.mappingFormToAbstractPet(data));
        return data;
      });
  };

  private mappingFormToAbstractPet(data: any) {
    const corePet = new AbstractPet;
    corePet.functionalIdentifier = data.functionalIdentifier;
    corePet.name = data.name;
    return corePet;
  };


}
