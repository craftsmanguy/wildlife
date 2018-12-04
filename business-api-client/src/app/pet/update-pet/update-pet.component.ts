import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Pet, AbstractPet, Race, GENDERS } from '../model';
import { PetService } from '../../services/pet.service';
import { CustomValidator } from '../../utils/validators';

import { Observable } from 'rxjs';

import { switchMap } from 'rxjs/operators';

import { first } from 'rxjs/operators';


@Component({
  selector: 'app-update-pet',
  templateUrl: './update-pet.component.html',
  styleUrls: ['./update-pet.component.css']
})
export class UpdatePetComponent implements OnChanges {

  @Input()
  id: string;

  @Output()
  actionUpdateSucceed: EventEmitter<AbstractPet> = new EventEmitter();

  filteredRaces: Observable<Race[]>;

  genders = GENDERS;
  petForm: FormGroup;
  submitted = false;

  pet: Pet;

  constructor(
    private formBuilder: FormBuilder,
    private petService: PetService,
  ) { }

  ngOnChanges() {
    this.get(this.id);
  }

  get(id: string) {
    this.petService.getPetById(id).subscribe(pet => {
      this.pet = pet;
      this.createForm();
    });
  };

  createForm() {
    if (this.pet !== undefined) {
      let position = 0;
      const lengthList = this.genders.length;
      for (let gender = 0; gender < lengthList; gender++) {
        if (this.genders[gender].code === this.pet.gender) {
          position = gender;
          break;
        }
      };

      this.petForm = this.formBuilder.group({
        gender: [this.genders[position].label, [Validators.required]],
        name: [this.pet.name, [Validators.required]],
        race: [this.pet.race, [Validators.required]],
        birth: [this.pet.birth, [Validators.required, Validators.pattern(CustomValidator.numberValidator)]],
        lof: [this.pet.lof, [Validators.required]],
        description: [this.pet.description]
      });

      this.filteredRaces = this.petForm
        .get('race')
        .valueChanges
        .pipe(
        switchMap(value => this.petService.searchRaceByName({ name: value }, 1))
        );
    }

  };

  displayFn(race: Race) {
    if (race) { return race.name; }
  };

  get formValues() {
    return this.petForm.controls;
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
        this.actionUpdateSucceed.emit(this.mappingFormToAbstractPet(data));
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
