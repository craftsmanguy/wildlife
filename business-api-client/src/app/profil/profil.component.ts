import { Component, OnInit, Input, Output, OnChanges, SimpleChanges, EventEmitter } from '@angular/core';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { UserService } from '../services/user.service';

import { FlatTreeControl } from '@angular/cdk/tree';
import { User, UserForPetAction, PetMinimal } from './model';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css'],
  providers: [UserService]
})
export class ProfilComponent implements OnInit, OnChanges {

  @Output() addPetAction: EventEmitter<UserForPetAction> = new EventEmitter();
  @Output() addCampaignAction: EventEmitter<String> = new EventEmitter();
  @Output() viewPetByIdAction: EventEmitter<UserForPetAction> = new EventEmitter();
  @Output() updatePetByIdAction: EventEmitter<UserForPetAction> = new EventEmitter();

  @Input() petAdded: any;
  @Input() updateAdded: any;
  @Input() campaignAdded: any;

  isButtonPetDisabled = false;
  isButtonCampaignDisabled = false;

  profil: User;

  panelOpenState = false;

  private action: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService,
  ) {

  }

  ngOnInit() {
    this.getCurrent();
  };

  ngOnChanges(changes: SimpleChanges) {
    if (this.profil !== undefined && this.profil.pets !== undefined) {
      if (changes.petAdded !== undefined && changes.petAdded.currentValue !== undefined) {
        this.profil.pets.push(changes.petAdded.currentValue);
        this.isButtonPetDisabled = !this.isButtonPetDisabled;
        this.addPetAction.emit();
      }
    }

    if (this.profil !== undefined && this.profil.adverts !== undefined) {
      if (changes.campaignAdded !== undefined && changes.campaignAdded.currentValue !== undefined) {
        this.profil.adverts.push(changes.campaignAdded.currentValue);
        this.isButtonCampaignDisabled = !this.isButtonCampaignDisabled;
        this.addCampaignAction.emit();
      }
    }
  };


  getCurrent() {
    this.userService.getCurrent().subscribe(profil => { this.profil = profil });
  };

  addPet() {
    const userForPetAction = new UserForPetAction();
    this.isButtonPetDisabled = !this.isButtonPetDisabled;
    this.action = 'ADD'
    userForPetAction.action = this.action;
    if (this.isButtonPetDisabled) {
      this.addPetAction.emit(userForPetAction);
    } else {
      this.addPetAction.emit();
    }
  };

  addCampaign() {
    this.isButtonCampaignDisabled = !this.isButtonCampaignDisabled;
    this.action = 'ADD';
    if (this.isButtonCampaignDisabled) {
      this.addCampaignAction.emit(this.action);
    } else {
      this.addCampaignAction.emit();
    }
  };

  viewPetById(id: string) {
    const userForPetAction = new UserForPetAction();
    this.action = 'VIEW'
    userForPetAction.action = this.action;
    userForPetAction.id = id;
    this.viewPetByIdAction.emit(userForPetAction);
  };

  updatePetById(id: string) {
    const userForPetAction = new UserForPetAction();
    this.action = 'UPDATE'
    userForPetAction.action = this.action;
    userForPetAction.id = id;
    this.updatePetByIdAction.emit(userForPetAction);
  };

  onDeleteSucceeds(idDelete: string) {
    if (idDelete) {
      let lengthList = this.profil.pets.length;
      for (let index = 0; index < lengthList; index++) {
        if (this.profil.pets[index].functionalIdentifier === idDelete) {
          this.profil.pets.splice(index, 1);
          break;
        }
      };

      lengthList = this.profil.adverts.length;
      for (let index = 0; index < lengthList; index++) {
        if (this.profil.adverts[index].functionalIdentifier === idDelete) {
          this.profil.adverts.splice(index, 1);
          break;
        }
      };

    }
  }
}
